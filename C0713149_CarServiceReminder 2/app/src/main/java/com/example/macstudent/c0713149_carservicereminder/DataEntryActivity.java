package com.example.macstudent.c0713149_carservicereminder;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.macstudent.c0713149_carservicereminder.databases.DBCar;
import com.example.macstudent.c0713149_carservicereminder.modals.car;

import java.util.Calendar;

public class DataEntryActivity extends AppCompatActivity {

    EditText serviceDate;
    EditText odometer;
    Spinner serviceType;
    EditText description;
    EditText cost;
    Spinner nextService;
    EditText nextChangeAfter;
    Spinner stationName;
    Button btnSave;

    DBCar dbCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        serviceDate = (EditText) findViewById(R.id.txtdate);
        odometer = (EditText) findViewById(R.id.txtOdometer);
        serviceType = (Spinner) findViewById(R.id.serviceType);
        description = (EditText) findViewById(R.id.txtDescription);
        cost = (EditText) findViewById(R.id.cost);
        nextService = (Spinner) findViewById(R.id.nextService);
        nextChangeAfter = (EditText) findViewById(R.id.txtNextChange);
        stationName = (Spinner) findViewById(R.id.stationName);
        btnSave = (Button) findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car c1 = new car();


                c1.setServiceDate(serviceDate.getText().toString());
                c1.setOdometer(odometer.getText().toString());
                c1.setServiceType((String) serviceType.getItemAtPosition(serviceType.getSelectedItemPosition()));
                c1.setDescription(description.getText().toString());
                c1.setCost(cost.getText().toString());
                c1.setNextService((String) nextService.getItemAtPosition(nextService.getSelectedItemPosition()));
                c1.setNextChange(nextChangeAfter.getText().toString());
                c1.setServiceStationName((String) stationName.getItemAtPosition(stationName.getSelectedItemPosition()));
                dbCar.addCar(c1);

            }
        });


        serviceDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int mYear = c.get(Calendar.YEAR);
                final int mMonth = c.get(Calendar.MONTH);
                final int mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(DataEntryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                serviceDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}
