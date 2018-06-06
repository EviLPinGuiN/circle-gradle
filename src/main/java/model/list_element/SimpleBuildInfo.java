package model.list_element;

import model.BuildResponseBody;
import model.build.BuildInfo;

/**
 * This class contains information that used on BuildCell in the build list
 */
public class SimpleBuildInfo {

    private int buildNum;
    private String branch;
    private String username;
    private String repoName;
    private String status;

    public SimpleBuildInfo convertBuildInfoToSimple(BuildInfo info) {
        this.setBranch(info.getBranch());
        this.setBuildNum(info.getBuildNum());
        this.setRepoName(info.getReponame());
        this.setUsername(info.getUsername());
        this.setStatus(info.getStatus());
        return this;
    }

    public SimpleBuildInfo convertBuildResponseBodyToSimple(BuildResponseBody info) {
        this.setBranch(info.getBranch());
        this.setBuildNum(info.getBuildNum());
        this.setRepoName(info.getReponame());
        this.setUsername(info.getUsername());
        this.setStatus(info.getStatus());
        return this;
    }

    public int getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(int buildNum) {
        this.buildNum = buildNum;
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

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
