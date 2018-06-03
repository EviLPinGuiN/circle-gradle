package model.build;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("is_user")
    private Boolean isUser;
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("name")
    private String name;
    @SerializedName("vcs_type")
    private String vcsType;
    @SerializedName("id")
    private Integer id;

    public Boolean getUser() {
        return isUser;
    }

    public void setUser(Boolean user) {
        isUser = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVcsType() {
        return vcsType;
    }

    public void setVcsType(String vcsType) {
        this.vcsType = vcsType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
