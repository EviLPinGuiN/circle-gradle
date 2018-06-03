package model;

import com.google.gson.annotations.SerializedName;

/**
    Response body for POST methods: retryBuild, cancelBuild
 */
public class BuildResponseBody {

    @SerializedName("vcs_url")
    private String vcsUrl;
    @SerializedName("build_url")
    private String buildUrl;
    @SerializedName("build_num")
    private Integer buildNum;
    @SerializedName("branch")
    private String branch;
    @SerializedName("committer_name")
    private String committerName;
    @SerializedName("committer_email")
    private String committerEmail;
    @SerializedName("subject")
    private String subject;
    @SerializedName("body")
    private String body; // commit message body
    @SerializedName("dont_build")
    private String dontBuild; // reason why we didn't build, if we didn't build
    @SerializedName("queued_at")
    private String queuedAt;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("stop_time")
    private String stopTime;
    @SerializedName("build_time_millis")
    private Integer buildTimeMillis;
    @SerializedName("username")
    private String username;
    @SerializedName("reponame")
    private String reponame;
    @SerializedName("lifecycle")
    private String lifecycle; // :queued, :scheduled, :not_run, :not_running, :running or :finished
    @SerializedName("outcome")
    private String outcome; // :canceled, :infrastructure_fail, :timedout, :failed, :no_tests or :success
    @SerializedName("status")
    private String status;  // :retried, :canceled, :infrastructure_fail, :timedout, :not_run, :running, :failed, :queued, :scheduled, :not_running, :no_tests, :fixed, :success
    @SerializedName("retry_of")
    private Integer retryOf;
    @SerializedName("previous")
    private Previous previous;

    public String getVcsUrl() {
        return vcsUrl;
    }

    public void setVcsUrl(String vcsUrl) {
        this.vcsUrl = vcsUrl;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public Integer getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(String queuedAt) {
        this.queuedAt = queuedAt;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getBuildTimeMillis() {
        return buildTimeMillis;
    }

    public void setBuildTimeMillis(Integer buildTimeMillis) {
        this.buildTimeMillis = buildTimeMillis;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReponame() {
        return reponame;
    }

    public void setReponame(String reponame) {
        this.reponame = reponame;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getDontBuild() {
        return dontBuild;
    }

    public void setDontBuild(String dontBuild) {
        this.dontBuild = dontBuild;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRetryOf() {
        return retryOf;
    }

    public void setRetryOf(Integer retryOf) {
        this.retryOf = retryOf;
    }

    public Previous getPrevious() {
        return previous;
    }

    public void setPrevious(Previous previous) {
        this.previous = previous;
    }
}
