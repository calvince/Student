package com.moshtel.students.exceptions;

public class DatabaseNotOpenException extends RuntimeException {

    public DatabaseNotOpenException(){
        super();
    }
    public DatabaseNotOpenException(String detailMessage) {
        super(detailMessage);
    }

    public DatabaseNotOpenException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DatabaseNotOpenException(Throwable throwable) {
        super(throwable);
    }

}
