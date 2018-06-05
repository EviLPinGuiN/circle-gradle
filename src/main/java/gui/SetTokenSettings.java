package gui;

import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SetTokenSettings implements SearchableConfigurable {
    TokenSettingsGUI mGUI;
    private JTextField textField;
    private JList listProjects;
    private String textReset;
    final StaticComponents stat = StaticComponents.getInstance();

    @Nls
    @Override
    public String getDisplayName() {
        return "Circle CI Plugin";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "circle.configurable";
    }

    @NotNull
    @Override
    public String getId() {
        return "circle.configurable";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mGUI = new TokenSettingsGUI();
        textField = mGUI.getTextField1();
        textReset = textField.getText();
        listProjects = mGUI.getListProjects();
        return mGUI.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return (!stat.getToken().equals(textField.getText()) || !stat.getProject().equals(listProjects.getSelectedValue()));
    }

    @Override
    public void apply() {
        stat.setToken(textField.getText());
        if (listProjects.getSelectedValue() != null) {
            stat.setProject(String.valueOf(listProjects.getSelectedValue()));
        }

    }
    @Override
    public void disposeUIResources() {
        mGUI = null;
    }

    @Override
    public void reset() {
        textField.setText(textReset);
    }
}