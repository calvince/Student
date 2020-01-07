package com.moshtel.students.models.requests;

public class FingerPrintValidationRequest {
    private String cardNumber;
    private String cardSerial;
    private String programNumber;
    private String template;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    public String getProgramNumber() {
        return programNumber;
    }

    public void setProgramNumber(String programNumber) {
        this.programNumber = programNumber;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
