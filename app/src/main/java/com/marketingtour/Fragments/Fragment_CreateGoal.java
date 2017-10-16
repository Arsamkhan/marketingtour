package com.marketingtour.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.marketingtour.Adapters.Adapter_CreateGoal;
import com.marketingtour.R;

import java.util.ArrayList;

/**
 * Created by uzairayub on 10/15/17.
 */

public class Fragment_CreateGoal extends Fragment implements View.OnClickListener {
    ArrayList<Integer> list;
    private RecyclerView recyclerView;
    private View view;
    private Button btnadd;
    private Spinner spinner;
    Adapter_CreateGoal adapter;
    String colors[] = {"Type A","Type B","Type C","Type D","Type E", "Type F","Type G","Type H","Type I"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_goal,container,false);
        initilizer();
        return view;
    }

    private void initilizer() {

        btnadd = (Button)view.findViewById(R.id.creategoal_btnadd);
        btnadd.setOnClickListener(this);
        spinner = (Spinner)view.findViewById(R.id.creategoal_types);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(),   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        list = new ArrayList<>();
        recyclerView = (RecyclerView)view.findViewById(R.id.creategoal_recyslerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        list.add(list.size()+1);
        adapter = new Adapter_CreateGoal(list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == btnadd.getId())
        {
            list.add(list.size()+1);
            adapter.notifyDataSetChanged();
        }
    }
}
