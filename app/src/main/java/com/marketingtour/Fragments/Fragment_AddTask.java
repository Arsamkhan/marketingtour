package com.marketingtour.Fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.marketingtour.Activities.ShowData;
import com.marketingtour.R;

import java.util.Calendar;

/**
 * Created by uzairayub on 10/14/17.
 */

public class Fragment_AddTask extends Fragment implements View.OnClickListener {

    Spinner spinner_typeOfTask, spinner_subType;
    Button btnsave;
    TextView txtdate;
    private Calendar calendar = Calendar.getInstance();
    private View view;
    String colors[] = {"Type A","Type B","Type C","Type D","Type E", "Type F","Type G","Type H","Type I"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Add Task");
        view = inflater.inflate(R.layout.fragment_addtask,container,false);
        initilizer();
        return view;
    }

    private void initilizer() {
        spinner_typeOfTask = (Spinner) view.findViewById(R.id.type_ofTask);
        spinner_subType = (Spinner) view.findViewById(R.id.subType_ofTask);
        btnsave = (Button) view.findViewById(R.id.addtask_btnsave);
        btnsave.setOnClickListener(this);
        txtdate = (TextView) view.findViewById(R.id.addtask_txtdate);
        txtdate.setOnClickListener(this);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner_typeOfTask.setAdapter(spinnerArrayAdapter);
        spinner_subType.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addtask_txtdate)
        {
            new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    txtdate.setText(year+"-"+(month+1)+"-"+day);

                }
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if (view.getId() == R.id.addtask_btnsave)
        {
            getContext().startActivity(new Intent(getContext(), ShowData.class));
        }
    }
}
