package model;

import com.google.gson.annotations.SerializedName;

public class Previous {

    @SerializedName("status")
    private String status;
    @SerializedName("build_num")
    private Integer buildNum;
    @SerializedName("build_time_millis")
    private Long buildTimeMillis;

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

    public Long getBuildTimeMillis() {
        return buildTimeMillis;
    }

    public void setBuildTimeMillis(Long buildTimeMillis) {
        this.buildTimeMillis = buildTimeMillis;
    }
}
