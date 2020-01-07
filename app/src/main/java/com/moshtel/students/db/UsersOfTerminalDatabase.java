package com.moshtel.students.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.Nullable;

import com.moshtel.students.models.response.GetUsersResponse;

public class UsersOfTerminalDatabase extends SQLiteOpenHelper {
    public static final String TAG = UsersOfTerminalDatabase.class.getSimpleName();
    private Context context;
    private static final int DATABASE_VERSION = 10;
    private String path = "/sdcard/students.bin";
    public static final String DATABASE_NAME = "students_database";
    public static final String USERS_TABLE = "users_table";
    public static final String STUDENT_TABLE = "student_table";
    public static final String TRANSACTION_TABLE = "transaction_table";

    //Transactions receipt table
    private static final String RECEIPT_TABLE = "receipt_table";

    //Fingerprints  table
    private static final String FINGERPRINTS_TABLE = "fingerprints_table";
    private static final String KEY_FINGER_NUMBER = "finger_number";
    private static final String KEY_STRING_FINGER_PRINTS = "fingerprints";

    // User Table Columns names
    private static final String KEY_DATE_CREATED = "date_created";
    private static final String KEY_USER_NAME = "name";
    private static final String KEY_TELLER_ID = "teller_id";
    private static final String  KEY_USER_TYPE = "user_type";
    private static final String KEY_USER_CODE = "user_code";
    private static final String KEY_ID_NUMBER = "id_number";
    private static final String KEY_STATUS = "status";
    private static final String KEY_PIN = "user_pin";
    private static final String KEY_IS_PIN_SET = "is_pin_set";

    //Students column table
    private static final String KEY_STUDENT_NAME = "student_name";
    private static final String KEY_CARD_STATUS = "card_status";
    private static final String KEY_ID = "student_id";
    private static final String KEY_CARD_NUMBER = "card_number";
    private static final String KEY_DISBURSE_ID = "disburse_id";
    private static final String KEY_LIMIT_AMOUNT = "limit_amount";
    private static final String KEY_STUDENT_STATUS = "student_status";
    private static final String KEY_SERVICE_POINT = "service_point";
    private static final String KEY_TERMINAL_STATUS = "terminal_status";
    private static final String KEY_VALIDATION_LEVEL = "validation_level";
    private static final String KEY_MESSAGE = "message";


    //Transaction column table
    private static final String KEY_TRANSACT_CARD_NUMBER = "transact_car_number";
    private static final String KEY_TRANS_TYPE = "trans_type";
    private static final String KEY_TRAN_TNXDATE = "trans_tnxdate";
    private static final String KEY_DISBURSEID = "disburseID";
    private static final String  KEY_TNXAMOUNT = "tnx_amount";
    private static final String KEY_TERMINAL_ID = "terminal_id";
    private static final String KEY_TRANS_ID = "trans_id";
    private static final String KEY_CARD_BALANCE = "card_balance";
    private static final String KEY_TNXTYPE = "tnxtype";
    private static final String KEY_CARDD_LIST = "card_list";
    private static final String KEY_AUTHTYPE = "auth_type";
    private static final String KEY_TNXID = "tnx_id";


    public UsersOfTerminalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //create user details
        String CREATE_USER_TABLE = "CREATE TABLE "
                + USERS_TABLE + "("
                + KEY_USER_CODE + " TEXT,"
                + KEY_USER_NAME + " TEXT,"
                + KEY_ID_NUMBER + " TEXT,"
                + KEY_TELLER_ID + " TEXT PRIMARY KEY,"
                + KEY_DATE_CREATED + " TEXT ,"
                + KEY_USER_TYPE + " INT ,"
                + KEY_PIN + " TEXT ,"
                + KEY_IS_PIN_SET + " INT ,"
                + KEY_STATUS + " INT" + ")";
        db.execSQL(CREATE_USER_TABLE);

        //create student detail table
        String CREATE_STUDENT_TABLE = "CREATE TABLE "
                + STUDENT_TABLE + "("
                + KEY_STUDENT_NAME + " TEXT,"
                + KEY_CARD_STATUS + "TEXT PRIMARY KEY,"
                + KEY_ID + "TEXT" + ")";
        db.execSQL(CREATE_STUDENT_TABLE);

        //create fingerprint table
        String CREATE_FINGERPRINTS_TABLE = "CREATE TABLE "
                + FINGERPRINTS_TABLE + "("
                + KEY_FINGER_NUMBER + "TEXT,"
                + KEY_STRING_FINGER_PRINTS + "TEXT" + ")";
            db.execSQL(CREATE_FINGERPRINTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TRANSACTION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FINGERPRINTS_TABLE);
        // Create tables again
        onCreate(db);

    }
    public void addUsersToTheDatabase(String type, String userCode, String name, String idNumber, String tellerId, String dateCreated, long userType, long status) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_CODE, userCode); // User code
        values.put(KEY_USER_NAME, name); // User name
        values.put(KEY_ID_NUMBER, idNumber); // Id number
        values.put(KEY_TELLER_ID, tellerId); // Teller id
        values.put(KEY_DATE_CREATED, dateCreated); // Date created
        values.put(KEY_USER_TYPE, userType); // User type
        values.put(KEY_PIN, ""); // PIN
        values.put(KEY_IS_PIN_SET, 0); // Is pin set
        values.put(KEY_STATUS, status); // Status

        // Inserting Row
        if (type.equalsIgnoreCase("login"))
//            db.insert(LOGIN_TABLE, null, values);
//        else
//            db.insert(USER_TABLE, null, values);

        db.close(); // Closing database connection

        Log.d(TAG, "Users added in the table: " + values);
    }

    public GetUsersResponse.Users  getTerminalUserByIdAndTellerId(String idNumber,String tellerId){
        GetUsersResponse.Users users = new GetUsersResponse.Users();
        String selectQuery = "SEKECT * FROM " + USERS_TABLE + " WHERE teller_id='" + tellerId + "' AND id_number='" + idNumber + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                //looping through all rows and adding to the list
                if (cursor.moveToFirst()){
                    do {
                        users.setUserCode(cursor.getString(0));
                        users.setName(cursor.getString(1));
                        users.setIdNumber(cursor.getString(2));
                        users.setTellerId(cursor.getString(3));
                        users.setDateCreated(cursor.getString(4));
                        users.setUserType(cursor.getLong(5));
                        users.setPin(cursor.getString(6));
                        users.setIs_pin_set(cursor.getInt(7));
                        users.setStatus(cursor.getLong(8));
                    }while (cursor.moveToNext());
                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore){

                }
            }


        }finally {
            try {
                db.close();
            }catch (Exception ignore){
            }
        }
        return users;
    }

    public GetUsersResponse.Users getUserByIdNumberAndSecretCode(String secretCode,String idNumber){
        GetUsersResponse.Users users = new GetUsersResponse.Users();

        String selectQuery = "SELECT  * FROM " + USERS_TABLE + " WHERE user_code='" + secretCode + "' AND id_number='" + idNumber + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()){
                    do {
                        users.setUserCode(cursor.getString(0));
                        users.setName(cursor.getString(1));
                        users.setIdNumber(cursor.getString(2));
                        users.setTellerId(cursor.getString(3));
                        users.setDateCreated(cursor.getString(4));
                        users.setUserType(cursor.getLong(5));
                        users.setPin(cursor.getString(6));
                        users.setIs_pin_set(cursor.getInt(7));
                        users.setStatus(cursor.getLong(8));
                    }while (cursor.moveToNext());
                }

            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore){

                }
            }

        }finally {
            try {
                db.close();
            }catch (Exception ignore){

            }
        }
        return users;
    }
    public GetUsersResponse.Users getTerminalUser(String tellerId,String pin,String type){

        GetUsersResponse.Users users = new GetUsersResponse.Users();
        String selectQuery;
        if (type.equalsIgnoreCase("getpin")){
            selectQuery = "SELECT  * FROM " + USERS_TABLE + " WHERE teller_id='" + tellerId + "'";
        }else {
            selectQuery = "SELECT  * FROM " + USERS_TABLE + " WHERE teller_id='" + tellerId + "' AND pin='" + pin + "'";
        }
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);            try {
                //looping through all rows and adding to the list
                if (cursor.moveToFirst()){
                    do {
                        users.setUserCode(cursor.getString(0));
                        users.setName(cursor.getString(1));
                        users.setIdNumber(cursor.getString(2));
                        users.setTellerId(cursor.getString(3));
                        users.setDateCreated(cursor.getString(4));
                        users.setUserType(cursor.getLong(5));
                        users.setPin(cursor.getString(6));
                        users.setIs_pin_set(cursor.getInt(7));
                        users.setStatus(cursor.getLong(8));
                    }while (cursor.moveToNext());
                }

            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore){

                }
            }

        }finally {
            try {
                db.close();
            }catch (Exception ignore){

            }
        }
        return users;

    }
    public void addBeneficiary(){

    }

    public void addReceiptNumber(String receipt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CARD_NUMBER,receipt);
        //inserting rows
        db.insert(RECEIPT_TABLE,null,values);
        //closing the db
        db.close();

        //log the information
        Log.e(TAG,"Fingerprint added to the table: " + values);
    }
    public int getCount(String type){
        int count = 0;
        String countQuery;
        if (type.equalsIgnoreCase("transaction"))
            countQuery = "SELECT * FROM " + TRANSACTION_TABLE;
        else
            countQuery = "SELECT * FROM " + TRANSACTION_TABLE ;

        SQLiteDatabase db = this.getReadableDatabase();
       try {
           String sql;
           Cursor cursor = db.rawQuery(countQuery, null);
           try {
               //looping through all rows and adding to list
               if (cursor.moveToFirst()){
                   do {
                       count = cursor.getCount();
                   }while (cursor.moveToNext());
               }
           }finally {
               try {
                   cursor.close();
               }catch (Exception ignore){

               }
           }

       }finally {
           try {
               db.close();
           }catch (Exception ignore){

           }
       }
       return count;
    }

    public int getReceiptNumber(){
        int count = 1;
        String countQuery = "SELECT MAX(receipt_number) FROM " + RECEIPT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(countQuery,null);
            try {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()){
                    do {
                        count = cursor.getInt(0);
                    }while (cursor.moveToNext());

                }
            }finally {
                try {
                    cursor.close();
                }catch (Exception ignore){

                }
            }
        }finally {
            try {
                db.close();
            }catch (Exception ignore){

            }
        }
        return count;
    }


}
