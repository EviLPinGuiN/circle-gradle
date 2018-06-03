import api.ApiClient;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.itis.BuildConfig;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.GithubUserHolder;
import model.UserHolder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;


public class ShowWindows implements ToolWindowFactory {

    private ToolWindow myToolWindow;
    private JPanel myToolWindowContent;
    private JTextField txtURL = new JTextField("Hello World!");
    private JButton startButton;
    private JPanel panel1;
    private Stage stage;
    private WebView browser;
    private JFXPanel jfxPanel;
    private JButton swingButton;
    private WebEngine webEngine;


    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        myToolWindow = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new BorderLayout());
        initComponents();
        Content content = contentFactory.createContent(myToolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    private void initComponents() {

        jfxPanel = new JFXPanel();
        createScene();

        myToolWindowContent.setLayout(new BorderLayout());
        myToolWindowContent.add(jfxPanel, BorderLayout.CENTER);
        myToolWindowContent.setMinimumSize(new Dimension(640, 480));

        swingButton = new JButton();
        swingButton.addActionListener(e -> Platform.runLater(() -> webEngine.reload()));
        swingButton.setText("Reload");

        myToolWindowContent.add(swingButton, BorderLayout.SOUTH);
    }

    /**
     * createScene
     * <p>
     * Note: Key is that Scene needs to be created and run on "FX user thread"
     * NOT on the AWT-EventQueue Thread
     */
    private void createScene() {
        String token = BuildConfig.TEST_TOKEN;
        ApiClient.getPhraseService()
                .getProfile()
                .map(UserHolder::getGithubUserHolder)
                .map(GithubUserHolder::getGithubUser)
                .subscribeOn(Schedulers.io())
                .subscribe(githubUser -> {
                    String login = githubUser.getLogin();
                    String name = githubUser.getName();
                });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebView view = new WebView();
                webEngine = view.getEngine();
                webEngine.load("https://circleci.com/");
                Scene scene = new Scene(view);
                jfxPanel.setScene(scene);
            }
        });
    }
}
