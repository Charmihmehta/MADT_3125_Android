package com.example.macstudent.c0713149_carservicereminder.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.macstudent.c0713149_carservicereminder.R;
import com.example.macstudent.c0713149_carservicereminder.modals.car;

import java.util.ArrayList;

/**
 * Created by macstudent on 2018-04-13.
 */

public class CarAdapter extends ArrayAdapter<car> {

    public CarAdapter(Context context, ArrayList<car> contactArrayList) {
        super(context, 0, contactArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        car c1 = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.id.setText(String.valueOf(c1.getId()));
        viewHolder.serviceDate.setText(c1.getServiceDate());
        viewHolder.odometer.setText(String.valueOf(c1.getOdometer()));
        viewHolder.serviceType.setText(c1.getServiceType());
        viewHolder.description.setText(String.valueOf(c1.getDescription()));
        viewHolder.cost.setText(c1.getCost());
        viewHolder.nextService.setText(String.valueOf(c1.getNextService()));
        viewHolder.nextChangeAfter.setText(c1.getNextChange());

        viewHolder.stationName.setText(c1.getServiceStationName());


        return convertView;
    }

    private class ViewHolder {
        TextView id;
        TextView serviceDate;
        TextView odometer;
        TextView serviceType;
        TextView description;
        TextView cost;
        TextView nextService;
        TextView nextChangeAfter;
        TextView stationName;

        ViewHolder(View convertView) {
            id = (TextView) convertView.findViewById(R.id.serviceId);
            serviceDate = (TextView) convertView.findViewById(R.id.serviceDate);
            odometer = (TextView) convertView.findViewById(R.id.odometer);
            serviceType = (TextView) convertView.findViewById(R.id.serviceType);
            description = (TextView) convertView.findViewById(R.id.description);
            cost = (TextView) convertView.findViewById(R.id.cost);
            nextService = (TextView) convertView.findViewById(R.id.nextService);
            nextChangeAfter = (TextView) convertView.findViewById(R.id.nextChange);
            stationName = (TextView) convertView.findViewById(R.id.serviceStationName);

        }
    }
}