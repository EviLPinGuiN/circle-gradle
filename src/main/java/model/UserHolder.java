package model;

import com.google.gson.annotations.SerializedName;

public class UserHolder {

    @SerializedName("name")
    private String name;

    @SerializedName("identities")
    private GithubUserHolder githubUserHolder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GithubUserHolder getGithubUserHolder() {
        return githubUserHolder;
    }

    public void setGithubUserHolder(GithubUserHolder githubUserHolder) {
        this.githubUserHolder = githubUserHolder;
    }
}
