package gui;

import actions.Rebuild;
import actions.RefreshProjects;
import api.ApiClient;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBColor;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.SimpleTreeStructure;
import com.itis.BuildConfig;
import model.build.BuildInfo;
import model.list_element.SimpleBuildInfo;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ShowWindows implements ToolWindowFactory {

    private ToolWindow myToolWindow;
    private JPanel myToolWindowContent;
    private JButton button1;
    private JPanel panel111;
    private JPanel workPanel;
    private SimpleTree buildTree;

    final StaticComponents stat = StaticComponents.getInstance();
    private SimpleTreeStructure buildStructure;
    private ActionToolbar _toolbar;
    private ContentFactory contentFactory;
    private Project myProject;
    private int buildNum;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        myToolWindow = toolWindow;
        myProject = project;
        DefaultActionGroup actionGroup =
                (DefaultActionGroup) ActionManager.getInstance().getAction("CircleCI.ProcessesToolbar");
        actionGroup.add(new RefreshProjects(this));
        actionGroup.addSeparator();
        actionGroup.add(new Rebuild(this));
        _toolbar = ActionManager.getInstance().createActionToolbar("CircleCI.ProcessesToolbar",
                actionGroup, true);
        contentFactory = ContentFactory.SERVICE.getInstance();
        buildTree = new SimpleTree();
        buildTree.setRootVisible(true);
        createTree();
    }

    private void addViewToScene(ContentFactory contentFactory, ToolWindow toolWindow, Component comp) {
        myToolWindowContent.setLayout(new BorderLayout());
        myToolWindowContent.add(comp, BorderLayout.CENTER);
        myToolWindowContent.add(_toolbar.getComponent(), BorderLayout.NORTH);
        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private void createTree() {
        ApiClient.getPhraseService()
                .getRecentBuildInfo(stat.getType(), stat.getUserName(),
                        stat.getProject(), BuildConfig.RECENT_BUILD_COUNT, null, null)
                .subscribe(list -> {
                    buildNum = list.get(0).getBuildNum();
                    List<SimpleBuildInfo> simpleBuildInfoList = convertToSimpleBuildInfo(list);
                    buildStructure = new BuildTreeStructure(myProject, buildTree, simpleBuildInfoList);

                    addViewToScene(contentFactory, myToolWindow, ScrollPaneFactory.createScrollPane(buildTree));
                }, error -> {
                    JLabel errorLabel = new JLabel();
                    errorLabel.setText(error.getMessage());
                    errorLabel.setForeground(JBColor.RED);
                    addViewToScene(contentFactory, myToolWindow, errorLabel);
                });
    }

    @NotNull
    private List<SimpleBuildInfo> convertToSimpleBuildInfo(List<BuildInfo> list) {
        List<SimpleBuildInfo> simpleBuildInfoList = new ArrayList<>();
        for (BuildInfo info : list) {
            SimpleBuildInfo temp = new SimpleBuildInfo();
            temp = temp.convertBuildInfoToSimple(info);
            simpleBuildInfoList.add(temp);
        }
        return simpleBuildInfoList;
    }

    public void synchronizeView() {
        ApiClient.getPhraseService()
                .getRecentBuildInfo(stat.getType(), stat.getUserName(),
                        stat.getProject(), BuildConfig.RECENT_BUILD_COUNT, null, null)
                .subscribe(list -> {
                    if (buildStructure instanceof BuildTreeStructure) {
                        List<SimpleBuildInfo> simpleBuildInfoList = convertToSimpleBuildInfo(list);
                        ((BuildTreeStructure) buildStructure).updateFromRoot(simpleBuildInfoList);

                    }
                }, error -> {
                    System.out.println(error.getMessage());
                });
    }

    public void errorWindow(final String message) {

    }

    public void retryLastBuild() {
        int selectedIndex = buildTree.getSelectedNode().getIndex() <= 0 ? 0 : buildTree.getSelectedNode().getIndex();
        int requestBuildNum = buildNum - selectedIndex;
        ApiClient.getPhraseService().retryBuild(stat.getType(), stat.getUserName(),
                stat.getProject(), requestBuildNum)
                .subscribe(build -> {
                    if (buildStructure instanceof BuildTreeStructure) {
                        SimpleBuildInfo temp = new SimpleBuildInfo();
                        temp = temp.convertBuildResponseBodyToSimple(build);
                        ((BuildTreeStructure) buildStructure).updateFromRoot(temp);
                    }
                }, error -> {

                });
    }
}
