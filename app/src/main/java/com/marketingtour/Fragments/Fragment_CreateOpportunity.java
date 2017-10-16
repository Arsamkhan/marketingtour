package com.marketingtour.Fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import com.marketingtour.R;
import java.util.Calendar;
/**
 * Created by uzairayub on 10/15/17.
 */

public class Fragment_CreateOpportunity extends Fragment implements View.OnClickListener {

    private TextView txtdate;
    private Spinner spiner;
    private View view;
    private Calendar calendar = Calendar.getInstance();
    String colors[] = {"Type A","Type B","Type C","Type D","Type E", "Type F","Type G","Type H","Type I"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Create Opportunity");
        view = inflater.inflate(R.layout.fragment_create_0pportunity,container,false);
        initilizer();
        return view;
    }

    private void initilizer() {

        txtdate = (TextView)view.findViewById(R.id.createopportunity_date);
        txtdate.setOnClickListener(this);
        spiner = (Spinner)view.findViewById(R.id.createopportunity_type);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spiner.setAdapter(spinnerArrayAdapter);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.createopportunity_date)
        {
            new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    txtdate.setText(year+"-"+(month+1)+"-"+day);

                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    }
}
