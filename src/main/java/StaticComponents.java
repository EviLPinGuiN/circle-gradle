import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

@State(
        name="SingleFileExecutionConfig",
        storages = {
                @Storage("SingleFileExecutionConfig.xml")}
)
public class StaticComponents implements PersistentStateComponent<StaticComponents> {
    String token;

    public StaticComponents() {
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
}
