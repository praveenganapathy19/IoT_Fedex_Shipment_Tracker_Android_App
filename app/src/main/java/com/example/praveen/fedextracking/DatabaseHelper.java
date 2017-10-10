package com.example.praveen.fedextracking;

/**
 * Created by Praveen on 10/08/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Creating database and table with all columns
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Package.db";
    public static final String TABLE_NAME = "Track_Package";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "SOURCE";
    public static final String COL_3 = "DESTINATION";
    public static final String COL_4 = "SENT_TIME";
    public static final String COL_5 = "CURR_LOCATION";
    public static final String COL_6 = "CURR_LOC_TIME";
    public static final String COL_7 = "WEIGHT";
    public static final String COL_8 = "TOT_PACKETS";

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SOURCE TEXT,DESTINATION TEXT,SENT_TIME DATETIME,CURR_LOCATION TEXT,CURR_LOC_TIME DATETIME,WEIGHT TEXT,TOT_PACKETS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //onCreate(db);
    }

    //inserting data from the Send packet page
    public boolean insertData(String source,String destination,String weight,String totPackets) {
        date = new Date();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,source);
        contentValues.put(COL_3,destination);
        contentValues.put(COL_4,dateFormat.format(date));
        contentValues.put(COL_5,source);
        contentValues.put(COL_7,weight);
        contentValues.put(COL_8,totPackets);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //gets table data for use in Track package page
    public Cursor getAllData(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where ID=\""+ID+"\"",null);
        Log.d("res", "res is: "+res.getCount());
        return res;
    }

    //gets ID from the recently inserted data
    public Cursor getID() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select ID from "+TABLE_NAME+" where ID=(SELECT MAX(ID) FROM "+TABLE_NAME+")",null);
        return res;
    }

    //updating the database from Send package page and runs in the background
    public boolean updateData(String ID,String curr_loc,String curr_loc_time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_5,curr_loc);
        contentValues.put(COL_6,curr_loc_time);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { ID });
        return true;
    }

}
