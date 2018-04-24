package com.example.macstudent.c0713149_carservicereminder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.macstudent.c0713149_carservicereminder.adapter.CarAdapter;
import com.example.macstudent.c0713149_carservicereminder.databases.DBCar;
import com.example.macstudent.c0713149_carservicereminder.modals.car;

import java.util.ArrayList;

public class ListOfDataActivity extends AppCompatActivity {

    CarAdapter carAdapter;
    ListView lstCars;
    ArrayList<car> carList;

    public  static void startIntent(Context context)
    {
        context.startActivity(new Intent(context,ListOfDataActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_data);


        lstCars = (ListView)findViewById(R.id.lstCars);

        DBCar dbContact = new DBCar(this);

        carList = (ArrayList<car>) dbContact.getAllCars();

        carAdapter = new CarAdapter(this,carList);
        lstCars.setAdapter(carAdapter);

        lstCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                car e = carList.get(i);
            }
        });
    }
}
