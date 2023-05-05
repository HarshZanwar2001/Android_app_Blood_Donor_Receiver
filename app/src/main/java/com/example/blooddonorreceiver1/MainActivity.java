package com.example.blooddonorreceiver1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        navigationView = (NavigationView) findViewById (R.id.nav);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId () == R.id.nav_donor) {
                    Intent i = new Intent (getApplicationContext (), Donor.class);
                    startActivity (i);
                } else if (item.getItemId () == R.id.nav_home) {
                    Intent h = new Intent (getApplicationContext (), MainActivity.class);
                    startActivity (h);
                } else if (item.getItemId () == R.id.nav_receiver) {
                    Intent s = new Intent (getApplicationContext (), ShowActivity.class);
                    startActivity (s);
                }else if(item.getItemId () == R.id.nav_about) {
                    Intent ab = new Intent (getApplicationContext (), About.class);
                    startActivity (ab);
                }else if(item.getItemId () == R.id.nav_share) {
                    Intent share = new Intent (Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_SUBJECT,"Check out My blood donor app");
                    share.putExtra(Intent.EXTRA_TEXT,"https://drive.google.com/file/d/1l8l1f1Eme16O4mti5E-EhnDApj8ac_w6/view?usp=sharing");
                    startActivity(Intent.createChooser(share,"Share"));
                }

                return false;

            }


        });
        drawerLayout = findViewById (R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle (this, drawerLayout, R.string.nav_open, R.string.nav_close);


        drawerLayout.addDrawerListener (actionBarDrawerToggle);
        actionBarDrawerToggle.syncState ();


        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected (item)) {
            return true;
        }
        return super.onOptionsItemSelected (item);
    }


    public void Donorform(View view) {
        Intent Donor = new Intent (getApplicationContext (), Donor.class);
        startActivity (Donor);
    }


    public void Receiverform(View view) {
        Intent s = new Intent (getApplicationContext (), ShowActivity.class);
        startActivity (s);
    }

    public void notification(View view) {
        Intent n = new Intent (getApplicationContext (), Notification.class);
        startActivity (n);
    }

    public void Service(View view) {
        Intent ser = new Intent (getApplicationContext (), Services.class);
        startActivity (ser);
    }





}

