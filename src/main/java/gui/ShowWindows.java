package gui;

import api.ApiClient;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.ColoredTreeCellRenderer;
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

    private static final String GITHUB = "github";

    private ToolWindow myToolWindow;
    private JPanel myToolWindowContent;
    private ColoredTreeCellRenderer coloredTreeCellRenderer;
    private SimpleTree buildTree;

    final StaticComponents stat = StaticComponents.getInstance();
    private SimpleTreeStructure buildStructure;


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        myToolWindow = toolWindow;

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

        buildTree = new SimpleTree();
        buildTree.setRootVisible(true);

        ApiClient.getPhraseService() // todo: need take username and project from settings
                .getRecentBuildInfo(GITHUB, "NailShaykhrazievItis",
                        "lessonTwo", BuildConfig.RECENT_BUILD_COUNT, null, null)
                .subscribe(list -> {
                    List<SimpleBuildInfo> simpleBuildInfoList = new ArrayList<>();
                    for (BuildInfo info : list) {
                        SimpleBuildInfo temp = new SimpleBuildInfo();
                        temp = temp.convertBuildInfoToSimple(info);
                        simpleBuildInfoList.add(temp);
                    }
                    buildStructure = new BuildTreeStructure(project, buildTree, simpleBuildInfoList);

                    addViewToScene(contentFactory, toolWindow, ScrollPaneFactory.createScrollPane(buildTree));
                }, error -> {
                    JLabel errorLabel = new JLabel();
                    errorLabel.setText(error.getMessage());
                    errorLabel.setForeground(JBColor.RED);
                    addViewToScene(contentFactory, toolWindow, errorLabel);
                });
    }

    private void addViewToScene(ContentFactory contentFactory, ToolWindow toolWindow, Component comp) {
        myToolWindowContent.setLayout(new BorderLayout());
        myToolWindowContent.add(comp, BorderLayout.CENTER);

        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
