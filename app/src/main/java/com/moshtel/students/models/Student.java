package com.moshtel.students.models;

import java.math.BigDecimal;

public class Student {
    private String names;
    private String cardStatus;
    private String Id;
    private String cardNumber;
    private String disburseId;
    private BigDecimal limitAmount;
    private String status;
    private String servicePoint;
    private String terminalStatus;
    private String validationLevel;
    private String ID;
    private String message;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDisburseId() {
        return disburseId;
    }

    public void setDisburseId(String disburseId) {
        this.disburseId = disburseId;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServicePoint() {
        return servicePoint;
    }

    public void setServicePoint(String servicePoint) {
        this.servicePoint = servicePoint;
    }

    public String getTerminalStatus() {
        return terminalStatus;
    }

    public void setTerminalStatus(String terminalStatus) {
        this.terminalStatus = terminalStatus;
    }

    public String getValidationLevel() {
        return validationLevel;
    }

    public void setValidationLevel(String validationLevel) {
        this.validationLevel = validationLevel;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
