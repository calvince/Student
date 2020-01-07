package com.moshtel.students.models.requests;

import com.moshtel.students.models.BaseRequest;

import java.util.ArrayList;

public class TransactionUploadRequest extends BaseRequest {
    private ArrayList<TransactionRequest> tnxDetail;

    public ArrayList<TransactionRequest> getTnxDetail() {
        return tnxDetail;
    }

    public void setTnxDetail(ArrayList<TransactionRequest> tnxDetail) {
        this.tnxDetail = tnxDetail;
    }
}
