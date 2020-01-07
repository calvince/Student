package com.moshtel.students.models.response;

import com.moshtel.students.models.BaseResponse;

import java.util.List;

public class GetUsersResponse extends BaseResponse {
    private String app_action;
    private String serverTime;
    private String terminalID;
    private long terminalStatus;

    private List<Users> users;

    public static class Users{
        private String dateCreated;
        private String name;
        private String tellerId;
        private Long userType;
        private String idNumber;
        private String userCode;
        private Long status;
        private String pin;
        private int is_pin_set;

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTellerId() {
            return tellerId;
        }

        public void setTellerId(String tellerId) {
            this.tellerId = tellerId;
        }

        public Long getUserType() {
            return userType;
        }

        public void setUserType(Long userType) {
            this.userType = userType;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public Long getStatus() {
            return status;
        }

        public void setStatus(Long status) {
            this.status = status;
        }

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public int getIs_pin_set() {
            return is_pin_set;
        }

        public void setIs_pin_set(int is_pin_set) {
            this.is_pin_set = is_pin_set;
        }
    }

    public String getApp_action() {
        return app_action;
    }

    public void setApp_action(String app_action) {
        this.app_action = app_action;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public long getTerminalStatus() {
        return terminalStatus;
    }

    public void setTerminalStatus(long terminalStatus) {
        this.terminalStatus = terminalStatus;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
