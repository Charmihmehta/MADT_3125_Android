package com.example.macstudent.c0713149_carservicereminder.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.macstudent.c0713149_carservicereminder.modals.car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macstudent on 2018-04-13.
 */

public class DBCar {

    static final String TABLE_CAR = "cars";
    static final String KEY_ID = "id";
    static final String KEY_SERVICE_DATE = "service_date";
    static final String KEY_ODOMETER = "odometer";
    static final String KEY_SERVICE_TYPE = "service_type";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_COST = "cost";
    static final String KEY_NEXT_SERVICE = "next_service";
    static final String KEY_NEXT_CHANGE_AFTER = "next_change";
    static final String KEY_SERVICE_STATION_NAME = "service_station_name";


    private DataBaseHandler dbHandler;
    private Context context;

    public DBCar(Context context) {
        this.context = context;
    }

    //adding new car

    public void addCar(car c1)
    {
        dbHandler = new DataBaseHandler(context);
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_SERVICE_DATE , c1.getServiceDate());
        cv.put(KEY_ODOMETER,c1.getOdometer());
        cv.put(KEY_SERVICE_TYPE,c1.getServiceType());
        cv.put(KEY_DESCRIPTION,c1.getDescription());
        cv.put(KEY_COST,c1.getCost());
        cv.put( KEY_NEXT_SERVICE,c1.getNextService());
        cv.put(KEY_NEXT_CHANGE_AFTER,c1.getNextChange());
        cv.put(KEY_SERVICE_STATION_NAME,c1.getServiceStationName());


        db.insert(TABLE_CAR, null,cv);
        db.close();


    }

    // Getting All Car
    public List<car> getAllCars() {
        dbHandler = new DataBaseHandler(context);
        List<car> carList = new ArrayList<car>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CAR;

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                car c1 = new car();
                c1.setId(Integer.parseInt(cursor.getString(0)));
                c1.setServiceDate(cursor.getString(1));
                c1.setOdometer(cursor.getString(2));
                c1.setServiceType(cursor.getString(3));
                c1.setDescription(cursor.getString(4));
                c1.setCost(cursor.getString(5));
                c1.setNextService(cursor.getString(6));
                c1.setNextChange(cursor.getString(7));
                c1.setServiceStationName(cursor.getString(8));



                // Adding contact to list
                carList.add(c1);
            } while (cursor.moveToNext());
        }

        // return contact list
        return carList;
    }

}
