package com.moshtel.students.models.requests;

public class GetStudentRequests {
    private String index;
    private String batchSize;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(String batchSize) {
        this.batchSize = batchSize;
    }
}
