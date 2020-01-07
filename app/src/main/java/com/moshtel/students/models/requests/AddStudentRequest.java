package com.moshtel.students.models.requests;

import com.moshtel.students.models.BaseRequest;

public class AddStudentRequest extends BaseRequest {
    private String CardNumber;
    private String CardUid;
    private String TerminalUser;
    private String StudentID;
    private boolean IsPreReg;
    private String RegDate;
    private String [] fingerprints;

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCardUid() {
        return CardUid;
    }

    public void setCardUid(String cardUid) {
        CardUid = cardUid;
    }

    public String getTerminalUser() {
        return TerminalUser;
    }

    public void setTerminalUser(String terminalUser) {
        TerminalUser = terminalUser;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public boolean isPreReg() {
        return IsPreReg;
    }

    public void setPreReg(boolean preReg) {
        IsPreReg = preReg;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String[] getFingerprints() {
        return fingerprints;
    }

    public void setFingerprints(String[] fingerprints) {
        this.fingerprints = fingerprints;
    }
}
