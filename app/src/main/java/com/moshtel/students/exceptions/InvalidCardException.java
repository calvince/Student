package com.moshtel.students.exceptions;

public class InvalidCardException extends RuntimeException {
    public InvalidCardException() {
        super();
    }

    public InvalidCardException(String detailMessage) {
        super(detailMessage);
    }

    public InvalidCardException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InvalidCardException(Throwable throwable) {
        super(throwable);
    }

}
