package com.moshtel.students.models;

public class BaseRequest {
    private String requestType;
    private String terminalID;
    private String appName;
    private String appVersion;
    private String requestDesc;
    private long tnxState;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    public long getTnxState() {
        return tnxState;
    }

    public void setTnxState(long tnxState) {
        this.tnxState = tnxState;
    }
}
