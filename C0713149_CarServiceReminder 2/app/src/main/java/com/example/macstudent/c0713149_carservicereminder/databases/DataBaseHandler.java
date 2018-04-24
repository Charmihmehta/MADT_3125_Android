package com.example.macstudent.c0713149_carservicereminder.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "car_db";
    private static final int DATABASE_VERSION = 2;


    public DataBaseHandler(Context context) {
        super(context,DATABASE_NAME ,null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE_CAR = "CREATE TABLE " + DBCar.TABLE_CAR + "("
                + DBCar.KEY_ID + "INTEGER PRIMARY KEY, " + DBCar.KEY_SERVICE_DATE + "TEXT, "
                +DBCar.KEY_ODOMETER + "TEXT," + DBCar.KEY_SERVICE_TYPE + "TEXT, "
                + DBCar.KEY_DESCRIPTION +"TEXT, " + DBCar.KEY_COST + "TEXT, "
                + DBCar.KEY_NEXT_SERVICE + "TEXT, " + DBCar.KEY_NEXT_CHANGE_AFTER+"TEXT, "
                +DBCar.KEY_SERVICE_STATION_NAME +"TEXT ) " ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


        db.execSQL("DROP TABLE IF EXISTS " + DBCar.TABLE_CAR);

        onCreate(db);

    }
}
