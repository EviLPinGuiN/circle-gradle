package model.branche;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Master {

    @SerializedName("running_builds")
    private List<Build> runningBuilds;
    @SerializedName("recent_builds")
    private List<Build> recentBuilds;
    @SerializedName("last_non_success")
    private Build lastNonSuccess;
    @SerializedName("pusher_logins")
    private List<String> pusherLogins;

    public List<Build> getRunningBuilds() {
        return runningBuilds;
    }

    public void setRunningBuilds(List<Build> runningBuilds) {
        this.runningBuilds = runningBuilds;
    }

    public List<Build> getRecentBuilds() {
        return recentBuilds;
    }

    public void setRecentBuilds(List<Build> recentBuilds) {
        this.recentBuilds = recentBuilds;
    }

    public Build getLastNonSuccess() {
        return lastNonSuccess;
    }

    public void setLastNonSuccess(Build lastNonSuccess) {
        this.lastNonSuccess = lastNonSuccess;
    }

    public List<String> getPusherLogins() {
        return pusherLogins;
    }

    public void setPusherLogins(List<String> pusherLogins) {
        this.pusherLogins = pusherLogins;
    }
}
