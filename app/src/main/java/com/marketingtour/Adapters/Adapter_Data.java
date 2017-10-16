package com.marketingtour.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marketingtour.Models.Model_Data;
import com.marketingtour.R;

import java.util.List;

/**
 * Created by asim on 10/14/17.
 */

public class Adapter_Data extends RecyclerView.Adapter<Adapter_Data.ViewHolder> {
    List<Model_Data> list;
    Context context;

    public Adapter_Data(Context context, List<Model_Data> list) {
        this.list = list;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvExcercise,tvTime,tvDate;
        private ImageView imExercise;
        public ViewHolder(View itemView) {
            super(itemView);
            try {
//                tvExcercise =(TextView) itemView.findViewById(R.id.textname);
//                tvTime =(TextView) itemView.findViewById(R.id.textTime);
//                tvDate =(TextView) itemView.findViewById(R.id.textdate);
//                imExercise = (ImageView) itemView.findViewById(R.id.imagepas);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }catch (Exception e){
                Log.d("TAG", "ViewHolder Exp:\n"+e.getMessage());
            }
        }
    }
}
