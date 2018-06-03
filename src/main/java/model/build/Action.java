package model.build;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nail on 03.06.2018.
 */
public class Action {

    @SerializedName("truncated")
    private Boolean truncated;
    @SerializedName("index")
    private Integer index;
    @SerializedName("parallel")
    private Boolean parallel;
    @SerializedName("failed")
    private Boolean failed;
    @SerializedName("infrastructure_fail")
    private Boolean infrastructureFail;
    @SerializedName("name")
    private String name;
    @SerializedName("bash_command")
    private Object bashCommand;
    @SerializedName("status")
    private String status;
    @SerializedName("timedout")
    private Object timedout;
    @SerializedName("continue")
    private Object _continue;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("type")
    private String type;
    @SerializedName("output_url")
    private String outputUrl;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("background")
    private Boolean background;
    @SerializedName("exit_code")
    private Object exitCode;
    @SerializedName("insignificant")
    private Boolean insignificant;
    @SerializedName("canceled")
    private Object canceled;
    @SerializedName("step")
    private Integer step;
    @SerializedName("run_time_millis")
    private Integer runTimeMillis;
    @SerializedName("has_output")
    private Boolean hasOutput;
    @SerializedName("source")
    private String source;

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getParallel() {
        return parallel;
    }

    public void setParallel(Boolean parallel) {
        this.parallel = parallel;
    }

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public Boolean getInfrastructureFail() {
        return infrastructureFail;
    }

    public void setInfrastructureFail(Boolean infrastructureFail) {
        this.infrastructureFail = infrastructureFail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBashCommand() {
        return bashCommand;
    }

    public void setBashCommand(Object bashCommand) {
        this.bashCommand = bashCommand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getTimedout() {
        return timedout;
    }

    public void setTimedout(Object timedout) {
        this.timedout = timedout;
    }

    public Object get_continue() {
        return _continue;
    }

    public void set_continue(Object _continue) {
        this._continue = _continue;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOutputUrl() {
        return outputUrl;
    }

    public void setOutputUrl(String outputUrl) {
        this.outputUrl = outputUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Boolean getBackground() {
        return background;
    }

    public void setBackground(Boolean background) {
        this.background = background;
    }

    public Object getExitCode() {
        return exitCode;
    }

    public void setExitCode(Object exitCode) {
        this.exitCode = exitCode;
    }

    public Boolean getInsignificant() {
        return insignificant;
    }

    public void setInsignificant(Boolean insignificant) {
        this.insignificant = insignificant;
    }

    public Object getCanceled() {
        return canceled;
    }

    public void setCanceled(Object canceled) {
        this.canceled = canceled;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getRunTimeMillis() {
        return runTimeMillis;
    }

    public void setRunTimeMillis(Integer runTimeMillis) {
        this.runTimeMillis = runTimeMillis;
    }

    public Boolean getHasOutput() {
        return hasOutput;
    }

    public void setHasOutput(Boolean hasOutput) {
        this.hasOutput = hasOutput;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
