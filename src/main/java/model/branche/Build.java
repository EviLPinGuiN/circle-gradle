package model.branche;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Build {

    @SerializedName("outcome")
    private String outcome;
    @SerializedName("status")
    private String status;
    @SerializedName("build_num")
    private Integer buildNum;
    @SerializedName("vcs_revision")
    private String vcsRevision;
    @SerializedName("pushed_at")
    private Date pushedAt;
    @SerializedName("is_workflow_job")
    private Boolean isWorkflowJob;
    @SerializedName("added_at")
    private Date addedAt;

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

    public Integer getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }

    public String getVcsRevision() {
        return vcsRevision;
    }

    public void setVcsRevision(String vcsRevision) {
        this.vcsRevision = vcsRevision;
    }

    public Date getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        this.pushedAt = pushedAt;
    }

    public Boolean getWorkflowJob() {
        return isWorkflowJob;
    }

    public void setWorkflowJob(Boolean workflowJob) {
        isWorkflowJob = workflowJob;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }
}
