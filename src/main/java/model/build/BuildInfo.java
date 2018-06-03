package model.build;


import com.google.gson.annotations.SerializedName;
import model.Previous;

import java.util.List;

public class BuildInfo {

    @SerializedName("compare")
    private String compare;
    @SerializedName("previous_successful_build")
    private Object previousSuccessfulBuild;
    @SerializedName("build_parameters")
    private Object buildParameters;
    @SerializedName("oss")
    private Boolean oss;
    @SerializedName("committer_date")
    private String committerDate;
    @SerializedName("steps")
    private List<Step> steps;
    @SerializedName("body")
    private String body;
    @SerializedName("usage_queued_at")
    private String usageQueuedAt;
    @SerializedName("fail_reason")
    private Object failReason;
    @SerializedName("retry_of")
    private Object retryOf;
    @SerializedName("reponame")
    private String reponame;
    @SerializedName("build_url")
    private String buildUrl;
    @SerializedName("parallel")
    private Integer parallel;
    @SerializedName("failed")
    private Boolean failed;
    @SerializedName("branch")
    private String branch;
    @SerializedName("username")
    private String username;
    @SerializedName("author_date")
    private String authorDate;
    @SerializedName("why")
    private String why;
    @SerializedName("user")
    private User user;
    @SerializedName("vcs_revision")
    private String vcsRevision;
    @SerializedName("owners")
    private List<String> owners;
    @SerializedName("build_num")
    private Integer buildNum;
    @SerializedName("infrastructure_fail")
    private Boolean infrastructureFail;
    @SerializedName("committer_email")
    private String committerEmail;
    @SerializedName("previous")
    private Previous previous;
    @SerializedName("status")
    private String status;
    @SerializedName("committer_name")
    private String committerName;
    @SerializedName("retries")
    private Object retries;
    @SerializedName("subject")
    private String subject;
    @SerializedName("vcs_type")
    private String vcsType;
    @SerializedName("timedout")
    private Boolean timedout;
    @SerializedName("lifecycle")
    private String lifecycle;
    @SerializedName("no_dependency_cache")
    private Boolean noDependencyCache;
    @SerializedName("stop_time")
    private String stopTime;
    @SerializedName("ssh_disabled")
    private Boolean sshDisabled;
    @SerializedName("build_time_millis")
    private Long buildTimeMillis;
    @SerializedName("messages")
    private List<Message> messages;
    @SerializedName("is_first_green_build")
    private Boolean isFirstGreenBuild;
    @SerializedName("job_name")
    private String jobName;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("canceler")
    private Object canceler;
    @SerializedName("platform")
    private String platform;
    @SerializedName("outcome")
    private String outcome;
    @SerializedName("vcs_url")
    private String vcsUrl;
    @SerializedName("author_name")
    private String authorName;
    @SerializedName("queued_at")
    private String queuedAt;
    @SerializedName("canceled")
    private Boolean canceled;
    @SerializedName("author_email")
    private String authorEmail;

    public String getCompare() {
        return compare;
    }

    public void setCompare(String compare) {
        this.compare = compare;
    }

    public Object getPreviousSuccessfulBuild() {
        return previousSuccessfulBuild;
    }

    public void setPreviousSuccessfulBuild(Object previousSuccessfulBuild) {
        this.previousSuccessfulBuild = previousSuccessfulBuild;
    }

    public Object getBuildParameters() {
        return buildParameters;
    }

    public void setBuildParameters(Object buildParameters) {
        this.buildParameters = buildParameters;
    }

    public Boolean getOss() {
        return oss;
    }

    public void setOss(Boolean oss) {
        this.oss = oss;
    }

    public String getCommitterDate() {
        return committerDate;
    }

    public void setCommitterDate(String committerDate) {
        this.committerDate = committerDate;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsageQueuedAt() {
        return usageQueuedAt;
    }

    public void setUsageQueuedAt(String usageQueuedAt) {
        this.usageQueuedAt = usageQueuedAt;
    }

    public Object getFailReason() {
        return failReason;
    }

    public void setFailReason(Object failReason) {
        this.failReason = failReason;
    }

    public Object getRetryOf() {
        return retryOf;
    }

    public void setRetryOf(Object retryOf) {
        this.retryOf = retryOf;
    }

    public String getReponame() {
        return reponame;
    }

    public void setReponame(String reponame) {
        this.reponame = reponame;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }

    public Integer getParallel() {
        return parallel;
    }

    public void setParallel(Integer parallel) {
        this.parallel = parallel;
    }

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorDate() {
        return authorDate;
    }

    public void setAuthorDate(String authorDate) {
        this.authorDate = authorDate;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVcsRevision() {
        return vcsRevision;
    }

    public void setVcsRevision(String vcsRevision) {
        this.vcsRevision = vcsRevision;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    public Integer getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }

    public Boolean getInfrastructureFail() {
        return infrastructureFail;
    }

    public void setInfrastructureFail(Boolean infrastructureFail) {
        this.infrastructureFail = infrastructureFail;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public Previous getPrevious() {
        return previous;
    }

    public void setPrevious(Previous previous) {
        this.previous = previous;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public Object getRetries() {
        return retries;
    }

    public void setRetries(Object retries) {
        this.retries = retries;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getVcsType() {
        return vcsType;
    }

    public void setVcsType(String vcsType) {
        this.vcsType = vcsType;
    }

    public Boolean getTimedout() {
        return timedout;
    }

    public void setTimedout(Boolean timedout) {
        this.timedout = timedout;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Boolean getNoDependencyCache() {
        return noDependencyCache;
    }

    public void setNoDependencyCache(Boolean noDependencyCache) {
        this.noDependencyCache = noDependencyCache;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Boolean getSshDisabled() {
        return sshDisabled;
    }

    public void setSshDisabled(Boolean sshDisabled) {
        this.sshDisabled = sshDisabled;
    }

    public Long getBuildTimeMillis() {
        return buildTimeMillis;
    }

    public void setBuildTimeMillis(Long buildTimeMillis) {
        this.buildTimeMillis = buildTimeMillis;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Boolean getFirstGreenBuild() {
        return isFirstGreenBuild;
    }

    public void setFirstGreenBuild(Boolean firstGreenBuild) {
        isFirstGreenBuild = firstGreenBuild;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Object getCanceler() {
        return canceler;
    }

    public void setCanceler(Object canceler) {
        this.canceler = canceler;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getVcsUrl() {
        return vcsUrl;
    }

    public void setVcsUrl(String vcsUrl) {
        this.vcsUrl = vcsUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(String queuedAt) {
        this.queuedAt = queuedAt;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
