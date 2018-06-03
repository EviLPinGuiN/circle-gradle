package model.build;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Step {

    @SerializedName("name")
    private String name;
    @SerializedName("actions")
    private List<Action> actions = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
