package com.marketingtour.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.marketingtour.R;

import java.util.ArrayList;

/**
 * Created by uzairayub on 10/15/17.
 */

public class Adapter_CreateGoal extends RecyclerView.Adapter<Adapter_CreateGoal.MyViewHolder> {
    ArrayList<Integer> list;
    Context context;
    String colors[] = {"Type A","Type B","Type C","Type D","Type E", "Type F","Type G","Type H","Type I"};
    public Adapter_CreateGoal(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.creategoal_item,parent,false);
        this.context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context,   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner_goal.setAdapter(spinnerArrayAdapter);
        holder.spinner_products.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public int getItemCount() {
        if(list != null)
        {
            return list.size();
        }
        else
        {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Spinner spinner_products, spinner_goal;
        public MyViewHolder(View itemView) {
            super(itemView);

            spinner_products = (Spinner) itemView.findViewById(R.id.creategoal_productspiner);
            spinner_goal = (Spinner) itemView.findViewById(R.id.creategoal_productgoal);
        }
    }
}
