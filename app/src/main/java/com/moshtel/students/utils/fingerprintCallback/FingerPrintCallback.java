/**
 * Copyright 2018, Bitel Co., LTD All Rights reserved.
 *
 * The interface of the processing the response from the fingerprint module
 *
 */
 
package com.moshtel.students.utils.fingerprintCallback;

import com.bitel.api.FpPacket;

public interface FingerPrintCallback {
    void onFingerPrintResponse(FingerPrint fingerPrint, FpPacket result);
}
