package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import gui.ShowWindows;

import javax.swing.*;

public class Rebuild extends AnAction {

    private static final Icon REFRESH_ICON = IconLoader.getIcon("/icons/ic_rebuild20.png");
    private ShowWindows windows;

    public Rebuild() {
    }

    public Rebuild(ShowWindows windows) {
        super("Rebuild", "Retries the build,", REFRESH_ICON);
        this.windows = windows;
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        try {
            windows.retryLastBuild();
        } catch (Exception ex) {
            windows.errorWindow("Unable to retry: " + ex.getMessage());
        }
    }
}
