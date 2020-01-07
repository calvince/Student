/**
 * Copyright 2018, Bitel Co., LTD All Rights reserved.
 *
 * The wrapper class for Fingerprint module
 *
 * This class wraps the <pre>FpDevice</pre> class (means 'FingerPrint device') and make it easier the user application
 * does the actions such as detectAndGetFingerPrints, match, search with the module device.
 *
 */

package com.moshtel.students.utils.fingerprintCallback;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bitel.api.FpDevice;
import com.bitel.api.FpPacket;

import static com.bitel.api.FpPacket.FP_CMD_CAPTURE;
import static com.bitel.api.FpPacket.FP_CMD_DELETE;
import static com.bitel.api.FpPacket.FP_CMD_DELETE_ALL;
import static com.bitel.api.FpPacket.FP_CMD_DETECT;
import static com.bitel.api.FpPacket.FP_CMD_ENROLL;
import static com.bitel.api.FpPacket.FP_CMD_GET_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_GET_ID_LIST;
import static com.bitel.api.FpPacket.FP_CMD_GET_IMAGE_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_GET_ISO_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_GET_ISO_IMAGE_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_GET_SAVED_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_GET_VALID_TEMPLATE_COUNT;
import static com.bitel.api.FpPacket.FP_CMD_LOAD_TEMPLATE;
import static com.bitel.api.FpPacket.FP_CMD_MATCH;
import static com.bitel.api.FpPacket.FP_CMD_MATCH_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_MATCH_ISO_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_SEARCH;
import static com.bitel.api.FpPacket.FP_CMD_SEARCH_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_SEARCH_ISO_FEATURE;
import static com.bitel.api.FpPacket.FP_CMD_STORE_TEMPLATE;
import static com.bitel.api.FpPacket.FP_CONTINUOUS_CAPTURE;


public class FingerPrint {
    private static final String TAG = "FingerPrint";

    /* Fingerprint device class */
    private FpDevice fpDevice;

    /* Fingerprint packet class */
    private FpPacket fpPacket;

    /* Callback class for returning value */
    private FingerPrintCallback fpCallback;

    /* constructor */
    public FingerPrint() {
        fpDevice = null;
        fpCallback = null;
    }

    /* Open the fingerprint device */
    public int Open() {
        int rv;
    // open the fingerprint class
        Log.d(TAG, "Open()");

        if (fpDevice == null) {
            fpDevice = new FpDevice();

            rv = fpDevice.Open();
            fpDevice.setHandler(handler);

            return rv;
        }
        else
            return -1;
    }

    /* Close the fingerprint device */
    public void Close() {
        if (fpDevice != null) {
            fpDevice = null;
            fpCallback = null;
        }
    }

    /* Get the firmware version of the fingerprint device */
    public String GetVersion() {
        return fpDevice.GetVersion();
    }

    /* Set the callback for returnging value */
    public void SetCallback(FingerPrintCallback cb) {
        fpCallback = cb;
    }

    /* Detect the finger is on the module sensor or not */
    public void Detect() {

        Log.d(TAG, "Detect()");

        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_DETECT;
        fpDevice.SendCommand(fpPacket);
    }

    /* Capture the image that is on the module sensor */
    public void Capture(short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_CAPTURE;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Caputre the image continuously */
    public void ContinuousCapture(short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CONTINUOUS_CAPTURE;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Register the feature on the module sensor to the library of fingerprint module. */
    public void Enroll(short index, int enroll_count, short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_ENROLL;
        fpPacket.mIndex = index;
        fpPacket.mTimeOut = timeout;
        fpPacket.mEnrollCount = enroll_count;
        fpDevice.SendCommand(fpPacket);
    }

    /* Compare the fingerprint feature on the module sensor with the specified feature in the library of the module */
    public void Match(short index, short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_MATCH;
        fpPacket.mIndex = index;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Search the fingerprint feature on the module sensor in the library of the module */
    public void Search(short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_SEARCH;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the valid template count in the library of the module */
    public void ValidTemplateCount() {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_VALID_TEMPLATE_COUNT;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the feature on the fingerprint module sensor */
    public void GetFeature(short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_FEATURE;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the feature in the specified index and feature number in the library of the module */
    public void GetSavedFeature(short index, int num_feature) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_SAVED_FEATURE;
        fpPacket.mIndex = index;
        fpPacket.mNumFeature = num_feature;
        fpDevice.SendCommand(fpPacket);
    }

    /* Delete all the template in the library of the module */
    public void DeleteAll() {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_DELETE_ALL;
        fpDevice.SendCommand(fpPacket);
    }

    /* Delete the specified template in the library of the module */
    public void Delete(short index) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_DELETE;
        fpPacket.mIndex = index;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the feature of the given fingerprint image */
    public void GetImageFeature(byte[] image) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_IMAGE_FEATURE;
        fpPacket.mImage = image;
        fpDevice.SendCommand(fpPacket);
    }

    /* Compare the fingerprint feature on the module sensor with the given feature */
    public void MatchFeature(byte[] feature, short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_MATCH_FEATURE;
        fpPacket.mFeature = feature;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Search the corresponding fingerprint feature in the library of the module with the given feature */
    public void SearchFeature(byte[] feature) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_SEARCH_FEATURE;
        fpPacket.mFeature = feature;
        fpDevice.SendCommand(fpPacket);
    }

    /* Load the specified template in the library of the module */
    public void LoadTemplate(short index) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_LOAD_TEMPLATE;
        fpPacket.mIndex = index;
        fpDevice.SendCommand(fpPacket);
    }

    /* Store the given template to the library of the module */
    public void StoreTemplate(short index, byte[] template) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_STORE_TEMPLATE;
        fpPacket.mIndex = index;
        fpPacket.mTemplate = template;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the count of the valid template and the index */
    public void GetList() {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_ID_LIST;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the fingerprint feature on the module sensor in ISO19794-2 format */
    public void ISO_GetFeature(short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_ISO_FEATURE;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Get the fingerprint feature with the given image in ISO19794-2 format */
    public void ISO_GetImageFeature(byte[] image) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_GET_ISO_IMAGE_FEATURE;
        fpPacket.mImage = image;
        fpDevice.SendCommand(fpPacket);
    }

    /* Compare the fingerprint image on the module sensor with the given feature in ISO19794-2 format */
    public void ISO_MatchFeature(byte[] iso_feature, short timeout) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_MATCH_ISO_FEATURE;
        fpPacket.mIsoFeature = iso_feature;
        fpPacket.mTimeOut = timeout;
        fpDevice.SendCommand(fpPacket);
    }

    /* Search the corresponding index in the library of the module with the given feature in    */
    public void ISO_SearchFeature(byte[] iso_feature) {
        if (fpDevice == null)
            return;

        fpPacket = new FpPacket();
        fpPacket.mCommandCode = FP_CMD_SEARCH_ISO_FEATURE;
        fpPacket.mIsoFeature = iso_feature;
        fpDevice.SendCommand(fpPacket);
    }

    /* Callback handler for sending the return value to user appliaction */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            FpPacket result = (FpPacket)msg.obj;

            if (fpCallback != null) {
                /* Send the result to user application */
                fpCallback.onFingerPrintResponse(FingerPrint.this, result);
            }


            return;
        }
    };

}
