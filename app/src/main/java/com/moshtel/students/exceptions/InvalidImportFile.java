package com.moshtel.students.exceptions;

public class InvalidImportFile extends RuntimeException {
    public InvalidImportFile(){
        super();
    }
    public InvalidImportFile(String detailMessage) {
        super(detailMessage);
    }

    public InvalidImportFile(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public InvalidImportFile(Throwable throwable) {
        super(throwable);
    }
}
