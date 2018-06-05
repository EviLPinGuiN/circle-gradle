package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import gui.ShowWindows;

import javax.swing.*;

public class RefreshProjects extends AnAction {

    private static final Icon REFRESH_ICON = IconLoader.getIcon("/icons/ic_refresh20.png");
    private ShowWindows windows;

    public RefreshProjects() {
    }

    public RefreshProjects(ShowWindows windows) {
        super("Synchronize", "Synchronize current builds", REFRESH_ICON);
        this.windows = windows;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        try {
            windows.synchronizeView();
        } catch (Exception ex) {
            windows.errorWindow("Unable to synchronize: " + ex.getMessage());
        }
    }
}
