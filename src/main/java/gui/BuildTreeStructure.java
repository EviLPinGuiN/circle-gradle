package gui;

import api.ApiClient;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.CachingSimpleNode;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import com.intellij.ui.treeStructure.SimpleTreeStructure;
import com.itis.BuildConfig;
import model.build.Step;
import model.list_element.SimpleBuildInfo;
import model.list_element.SimpleLogInfo;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.List;

public class BuildTreeStructure extends SimpleTreeStructure {

    private static final String CIRCLE_CI = "CircleCI";

    final StaticComponents stat = StaticComponents.getInstance();
    private RootNode rootNode;
    private final SimpleTreeBuilder simpleTreeBuilder;

    public BuildTreeStructure(Project project, JTree tree, List<SimpleBuildInfo> infoList) {
        this.rootNode = new RootNode(infoList);
        simpleTreeBuilder = new SimpleTreeBuilder(tree, (DefaultTreeModel) tree.getModel(),
                this, null);
        Disposer.register(project, simpleTreeBuilder);
        simpleTreeBuilder.initRoot();
        simpleTreeBuilder.expand(rootNode, null);
    }

    public void updateFromRoot(List<SimpleBuildInfo> infoList) {
        rootNode.updateBuildList(infoList);
        simpleTreeBuilder.updateFromRoot(true);
    }

    public void updateFromRoot(SimpleBuildInfo single) {
        rootNode.addToBuildList(single);
        simpleTreeBuilder.updateFromRoot(true);
    }

    @Override
    public Object getRootElement() {
        return rootNode;
    }

    public abstract class NamedNode extends CachingSimpleNode {

        protected NamedNode(SimpleNode aParent, String name) {
            super(aParent);
            myName = name;
        }
    }

    public class RootNode extends NamedNode {

        protected List<SimpleBuildInfo> list;

        public RootNode(List<SimpleBuildInfo> info) {
            super(null, "Root");
            myName = CIRCLE_CI;
            myClosedIcon = IconLoader.getIcon("/icons/ic_circle.png");
            list = info;
        }

        public void updateBuildList(List<SimpleBuildInfo> info) {
            list.clear();
            list.addAll(info);
            this.cleanUpCache();
            this.buildChildren();
            updatePresentation();
        }

        public void addToBuildList(SimpleBuildInfo build) {
            list.add(0, build);
            this.cleanUpCache();
            this.buildChildren();
            updatePresentation();
        }

        private void updatePresentation() {
            PresentationData presentation = getPresentation();
            presentation.clear();
            presentation.addText(myName, SimpleTextAttributes.REGULAR_ATTRIBUTES);
            update(presentation);
        }

        @Override
        protected SimpleNode[] buildChildren() {
            SimpleNode[] nodes = new SimpleNode[BuildConfig.RECENT_BUILD_COUNT];
            for (int i = 0; i < BuildConfig.RECENT_BUILD_COUNT; i++) {
                SimpleBuildInfo current = list.get(i);
                String levelOneNodeName = current.getUsername() + "/" + current.getRepoName() + "/" +
                        current.getBranch() + "#" + current.getBuildNum();
                nodes[i] = new BuildNote(this, levelOneNodeName, current.getStatus(), current.getBuildNum());
            }
            return nodes;
        }
    }

    public class BuildNote extends NamedNode {

        private int buildNum;
        private List<Step> stepList;

        public BuildNote(SimpleNode aParent, String name, String status, int buildNum) {
            super(aParent, name);
            this.buildNum = buildNum;
            getLogs();
            initIcon(status);
            updatePresentation();
        }

        private void initIcon(String status) {
            String path;
            switch (status) {
                case "failed":
                    path = "/icons/ic_red.png";
                    break;
                case "success":
                    path = "/icons/ic_green.png";
                    break;
                case "running":
                case "queued":
                case "scheduled":
                    path = "/icons/ic_blue.png";
                    break;
                default:
                    path = "/icons/ic_circle.png";
                    break;
            }
            myClosedIcon = IconLoader.getIcon(path);
        }

        private void updatePresentation() {
            PresentationData presentation = getPresentation();
            presentation.clear();
            presentation.addText(myName, SimpleTextAttributes.REGULAR_ATTRIBUTES);
            update(presentation);
        }

        private void getLogs() {
            ApiClient.getPhraseService().getSingleBuildInfo(stat.getType(), stat.getUserName(),
                    stat.getProject(), buildNum)
                    .subscribe(buildInfo -> {
                        stepList = buildInfo.getSteps() != null ? buildInfo.getSteps() : new ArrayList<>();
                        updatePresentation();
                    }, error -> { });
        }

        @Override
        protected SimpleNode[] buildChildren() {
            SimpleNode[] nodes;
            if (stepList != null && stepList.size() > 0) {
                nodes = new SimpleNode[stepList.size()];
                for (int i = 0; i < stepList.size(); i++) {
                    SimpleLogInfo logInfo = new SimpleLogInfo();
                    logInfo = logInfo.convertBuildInfoToSimpleLog(stepList.get(i).getActions().get(0));
                    String levelTwoNodeName = logInfo.getName();
                    nodes[i] = new LogNode(this, levelTwoNodeName, logInfo.getStatus(), logInfo.getRunTimeMillis());
                }
            } else {
                nodes = new SimpleNode[1];
                nodes[1] = new LogNode(this, "Not information", "pending", 1L);
            }
            return nodes;
        }
    }

    public class LogNode extends NamedNode {

        private Long mills;

        public LogNode(SimpleNode aParent, String name, String status, Long mills) {
            super(aParent, name);
            this.mills = mills;
            initIcon(status);
            updatePresentation();
        }

        private void initIcon(String status) {
            String path;
            switch (status) {
                case "failed":
                    path = "/icons/ic_failed.png";
                    break;
                case "success":
                    path = "/icons/ic_success.png";
                    break;
                case "running":
                case "queued":
                case "scheduled":
                    path = "/icons/ic_pending.png";
                    break;
                default:
                    path = "/icons/ic_pending.png";
                    break;
            }
            myClosedIcon = IconLoader.getIcon(path);
        }

        private void updatePresentation() {
            PresentationData presentation = getPresentation();
            presentation.clear();
            presentation.addText(myName, SimpleTextAttributes.REGULAR_ATTRIBUTES);
            if (mills == null) {
                mills = 1L;
            }
            presentation.addText(" " + mills.toString() + " ms", SimpleTextAttributes.GRAYED_BOLD_ATTRIBUTES);
            update(presentation);
        }

        @Override
        protected SimpleNode[] buildChildren() {
            return NO_CHILDREN;
        }
    }
}
