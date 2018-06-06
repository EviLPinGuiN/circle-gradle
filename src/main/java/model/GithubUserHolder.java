package model;

import com.google.gson.annotations.SerializedName;

public class GithubUserHolder {

    @SerializedName("github")
    private GithubUser githubUser;

    public GithubUser getGithubUser() {
        return githubUser;
    }

    public void setGithubUser(GithubUser githubUser) {
        this.githubUser = githubUser;
    }
}
