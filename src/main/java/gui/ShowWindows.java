package gui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;


public class ShowWindows implements ToolWindowFactory {

    private ToolWindow myToolWindow;
    private JPanel myToolWindowContent;
    private ColoredTreeCellRenderer coloredTreeCellRenderer;
    private Tree buildTree;
    final StaticComponents stat = StaticComponents.getInstance();


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        myToolWindow = toolWindow;

        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        buildTree = createTree();

        myToolWindowContent.setLayout(new BorderLayout());
        myToolWindowContent.add(ScrollPaneFactory.createScrollPane(buildTree), BorderLayout.CENTER);

        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private Tree createTree() {
        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        String item = "Item";
        SimpleTree tree = new SimpleTree();
        tree.getEmptyText().setText("LOADING");
        tree.setCellRenderer(coloredTreeCellRenderer);
        tree.setName("buildTree");
        tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(item)));
        return tree;
    }

    /**
     * createScene
     * <p>
     * Note: Key is that Scene needs to be created and run on "FX user thread"
     * NOT on the AWT-EventQueue Thread
     */
    private void createScene() {

    }
}
