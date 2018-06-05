package gui;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

@State(name = "CircleCIConfig", storages = {
        @Storage("CircleCIConfig.xml")})
public class StaticComponents implements PersistentStateComponent<StaticComponents> {
    private String token;
    private String project;
    private String username;
    private String type;

    public StaticComponents() {
        if (token == null) {
            token = "";
        }
        if (project == null) {
            project = "";
        }
        if (username == null) {
            username = "";
        }
        if (type == null) {
            type = "";
        }
        System.out.println("constr");
    }

    @Override
    public StaticComponents getState() {
        System.out.println("get_state");
        return this;
    }

    @Override
    public void loadState(StaticComponents state) {
        System.out.println("save_state");
        XmlSerializerUtil.copyBean(state, this);
    }

    public static StaticComponents getInstance() {
        return ServiceManager.getService(StaticComponents.class);
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
