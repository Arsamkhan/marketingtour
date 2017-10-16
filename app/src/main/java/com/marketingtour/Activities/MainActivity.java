package com.marketingtour.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.marketingtour.Fragments.Fragment_AddTask;
import com.marketingtour.Fragments.Fragment_CreatMeeting;
import com.marketingtour.Fragments.Fragment_CreateGoal;
import com.marketingtour.Fragments.Fragment_CreateOpportunity;
import com.marketingtour.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerInitilizer();
    }

    private void drawerInitilizer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new Fragment_AddTask());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addtask)
        {
            showdialouge();
            setFragment(new Fragment_AddTask());
        }
        else if (id == R.id.nav_createmeeting)
        {
            setFragment(new Fragment_CreatMeeting());
        }
        else if (id == R.id.nav_opportunities)
        {
            showdialouge_opp();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_container, fragment).addToBackStack(getTitle().toString()).commit();
    }


    void showdialouge ()
    {
        dialog = new Dialog(MainActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_addnew);

        Button btn1,btn2,btn3;
        btn1 = (Button)dialog.findViewById(R.id.dialog_btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button)dialog.findViewById(R.id.dialog_btn2);
        btn2.setOnClickListener(this);
        btn3 = (Button)dialog.findViewById(R.id.dialog_btn3);

        btn3.setOnClickListener(this);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dialog_btn1)
        {
            dialog.dismiss();
            setFragment(new Fragment_AddTask());
        }
        else if(view.getId() == R.id.dialog_btn2)
        {
            dialog.dismiss();
            startActivity(new Intent(MainActivity.this,ShowData.class));
        }

        else if(view.getId() == R.id.dialog_btn3)
        {dialog.dismiss();
            dialog.dismiss();
            startActivity(new Intent(MainActivity.this,ShowData.class));
        }
        else if(view.getId() == R.id.dialog_opbtn1)
        {
            dialog.dismiss();
            setFragment(new Fragment_CreateOpportunity());
        }
        else if(view.getId() == R.id.dialog_opbtn2)
        {
            dialog.dismiss();
            setFragment(new Fragment_CreateGoal());
        }
        else if(view.getId() == R.id.dialog_opbtn3)
        {
            dialog.dismiss();
            startActivity(new Intent(MainActivity.this,ShowData.class));
        }
    }
    void showdialouge_opp()
    {
        dialog = new Dialog(MainActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_oppertunity);

        Button btn1,btn2,btn3;
        btn1 = (Button)dialog.findViewById(R.id.dialog_opbtn1);
        btn1.setOnClickListener(this);
        btn2 = (Button)dialog.findViewById(R.id.dialog_opbtn2);
        btn2.setOnClickListener(this);
        btn3 = (Button)dialog.findViewById(R.id.dialog_opbtn3);

        btn3.setOnClickListener(this);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
    }
}
