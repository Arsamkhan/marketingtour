package com.marketingtour.Activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.marketingtour.Adapters.Adapter_Data;
import com.marketingtour.Models.Model_Data;
import com.marketingtour.R;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model_Data> list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.showdata_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backarrow_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        context = this;

        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        list = new ArrayList<Model_Data>();
        list.add(new  Model_Data("Gray",R.drawable.logo,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("RED",R.drawable.cameraicon,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("Green",R.drawable.icon,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("Blue",R.drawable.cameraicon,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("Gray",R.drawable.logo,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("RED",R.drawable.cameraicon,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("Green",R.drawable.icon,"00:00 am","12/12/2017"));
        list.add(new  Model_Data("Blue",R.drawable.cameraicon,"00:00 am","1 2/12/2017"));

        Adapter_Data adapter_data = new Adapter_Data(context, list);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter_data);
    }
}
