package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import gui.SetTokenSettings;

import javax.swing.*;

public class OpenSettingsAction extends AnAction implements DumbAware{

    private static final Icon REFRESH_ICON = IconLoader.getIcon("/icons/ic_settings.png");

    public OpenSettingsAction() {
        super("Settings", "Open plugin settings", REFRESH_ICON);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        showSettingsFor(getProject(event));
    }

    private static void showSettingsFor(Project project) {
        ShowSettingsUtil.getInstance().showSettingsDialog(project, SetTokenSettings.class);
    }

    static Project getProject(AnActionEvent event) {
        DataContext dataContext = event.getDataContext();
        return PlatformDataKeys.PROJECT.getData(dataContext);
    }
}
