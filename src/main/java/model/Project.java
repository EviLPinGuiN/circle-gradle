package model;

import com.google.gson.annotations.SerializedName;
import model.branche.Branches;


public class Project {

    @SerializedName("vcs_url")
    private String vcsUrl;
    @SerializedName("followed")
    private Boolean followed;
    @SerializedName("username")
    private String userName;
    @SerializedName("reponame")
    private String repoName;
    @SerializedName("branches")
    private Branches branches;
    @SerializedName("language")
    private String language;
    @SerializedName("vcs_type")
    private String type;

    public String getVcsUrl() {
        return vcsUrl;
    }

    public void setVcsUrl(String vcsUrl) {
        this.vcsUrl = vcsUrl;
    }

    public Boolean getFollowed() {
        return followed;
    }

    public void setFollowed(Boolean followed) {
        this.followed = followed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public Branches getBranches() {
        return branches;
    }

    public void setBranches(Branches branches) {
        this.branches = branches;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
