package model.list_element;

import model.build.Action;

/**
 * This class contains information that used on LogCell in the build list
 */
public class SimpleLogInfo {

    private String name;
    private String status;
    private Long runTimeMillis;

    public SimpleLogInfo convertBuildInfoToSimpleLog(Action action) {
        this.setName(action.getName());
        this.setStatus(action.getStatus());
        this.setRunTimeMillis(action.getRunTimeMillis());
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRunTimeMillis() {
        return runTimeMillis;
    }

    public void setRunTimeMillis(Long runTimeMillis) {
        this.runTimeMillis = runTimeMillis;
    }
}
