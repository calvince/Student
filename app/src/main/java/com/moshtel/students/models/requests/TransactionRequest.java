package com.moshtel.students.models.requests;

public class TransactionRequest {
//    private String custID;
    private String cardNumber;
    private String transType;
    private String tnxDate;
    private String disburseId;
    private Integer tnxAmount;
    private String transId;
    private Integer cardBalance;
    private String transStr;
    private String terminalUser;
    private String status;
    private String custName;
    private String cardDList;
    private String tnxID;
    private String TerminalId;
    private String Names;
    private String tnxType;
    private String authType;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTnxDate() {
        return tnxDate;
    }

    public void setTnxDate(String tnxDate) {
        this.tnxDate = tnxDate;
    }

    public String getDisburseId() {
        return disburseId;
    }

    public void setDisburseId(String disburseId) {
        this.disburseId = disburseId;
    }

    public Integer getTnxAmount() {
        return tnxAmount;
    }

    public void setTnxAmount(Integer tnxAmount) {
        this.tnxAmount = tnxAmount;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }


    public Integer getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Integer cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getTransStr() {
        return transStr;
    }

    public void setTransStr(String transStr) {
        this.transStr = transStr;
    }

    public String getTerminalUser() {
        return terminalUser;
    }

    public void setTerminalUser(String terminalUser) {
        this.terminalUser = terminalUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCardDList() {
        return cardDList;
    }

    public void setCardDList(String cardDList) {
        this.cardDList = cardDList;
    }

    public String getTnxID() {
        return tnxID;
    }

    public void setTnxID(String tnxID) {
        this.tnxID = tnxID;
    }

    public String getTerminalId() {
        return TerminalId;
    }

    public void setTerminalId(String terminalId) {
        TerminalId = terminalId;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getTnxType() {
        return tnxType;
    }

    public void setTnxType(String tnxType) {
        this.tnxType = tnxType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }
}
