package com.moshtel.students.exceptions;

public class LogoNotFoundException extends RuntimeException {
    public LogoNotFoundException() {
        super();
    }

    public LogoNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    public LogoNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public LogoNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
