package com.moshtel.students.exceptions;

public class MakeDirException extends RuntimeException {
    public MakeDirException(){
        super();
    }
    public MakeDirException(String detailMessage) {
        super(detailMessage);
    }

    public MakeDirException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public MakeDirException(Throwable throwable) {
        super(throwable);
    }
}
