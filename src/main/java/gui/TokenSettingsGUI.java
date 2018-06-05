package gui;

import api.ApiClient;
import com.intellij.ui.JBColor;
import io.reactivex.schedulers.Schedulers;
import model.GithubUserHolder;
import model.Project;
import model.UserHolder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TokenSettingsGUI {
    final StaticComponents stat = StaticComponents.getInstance();
    ArrayList<String> data = new ArrayList<String>();
    private JPanel rootPanel;
    private JTextField tokenText;
    private JButton testButton;
    private JLabel testText;
    private JLabel label;
    private JList listProjects;
    private JPanel panelProject;
    private List<Project> projects;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    TokenSettingsGUI() {
        createUIComponents();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JTextField getTextField1() {
        return tokenText;
    }

    public JList getListProjects() {
        return listProjects;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
//        rootPanel = new JPanel();
//       rootPanel.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
//        rootPanel.setRequestFocusEnabled(true);
//        rootPanel.add(textField1);

    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    private void createUIComponents() {

        panelProject.setVisible(false);
        listProjects.setVisible(false);
        if (stat.getToken() != null) {
            tokenText.setText(stat.getToken());
            checkToken();
        }
        testButton.addActionListener(e -> {
            stat.setToken(tokenText.getText());
            checkToken();
        });
    }

    private void checkToken() {
        ApiClient.getPhraseService()
                .getProfile()
                .map(UserHolder::getGithubUserHolder)
                .map(GithubUserHolder::getGithubUser)
                .subscribeOn(Schedulers.io())
                .subscribe(githubUser -> {
                    String login = githubUser.getLogin();
                    testText.setText("Success! You logged as " + login);
                    testText.setForeground(Color.decode("#4CAF50"));
                    panelProject.setVisible(true);
                    listProjects.setVisible(true);
                    showProjects();
                }, error -> {
                    panelProject.setVisible(false);
                    listProjects.setVisible(false);
                    testText.setText("Error! Please, check your token.");
                    testText.setForeground(Color.RED);
                });
    }

    private void showProjects() {
        ApiClient.getPhraseService()
                .getAllProjects()
                .subscribeOn(Schedulers.io())
                .subscribe(projects -> {
                    this.projects = projects;
                    data.clear();
                    projects.forEach(project -> {
                                data.add(project.getRepoName());
                                System.out.println(project.getRepoName());
                            }
                    );
                    listProjects.setListData(data.toArray());
                    if(stat.getProject() != null) listProjects.setSelectedValue(stat.getProject(), true);
                }, error -> {
                    testText.setText("Error! Please, check your token.");
                    testText.setForeground(JBColor.RED);
                });
    }

}
