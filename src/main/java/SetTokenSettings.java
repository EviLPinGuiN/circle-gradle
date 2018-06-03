import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SetTokenSettings implements SearchableConfigurable {
    TokenSettingsGUI mGUI;
    private JTextField textField;
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
        return mGUI.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return (!stat.getToken().equals(textField.getText()));
    }

    @Override
    public void apply() throws ConfigurationException {
        stat.setToken(textField.getText());
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