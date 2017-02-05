package com.phoenix.codeutsava.maa.home;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDex;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.discuss.view.Questions;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.view.HomeFragment;
import com.phoenix.codeutsava.maa.further_reading.view.FurtherReadingFragment;
import com.phoenix.codeutsava.maa.gallery.view.GalleryFragment;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.view.FirstVaccineFragment;
import com.phoenix.codeutsava.maa.maps.view.Geotag;
import com.phoenix.codeutsava.maa.vaccination_schedule.view.ScheduleScreenFragment;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        MultiDex.install(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setFragment(new FirstVaccineFragment(),"Geo");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new HomeFragment(),"Home");
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            setFragment(new HomeFragment(),"Home");
        } else if (id == R.id.nav_vaccine) {
            setFragment(new ScheduleScreenFragment(),"Vaccines Scheduled");
        } else if (id == R.id.nav_maps) {
            setFragment(new Geotag(),"Nearby Hospitals");
        }else if (id == R.id.nav_discuss) {
            setFragment(new Questions(),"Discussion");
        }
        else if (id == R.id.nav_readFurther) {
            setFragment(new FurtherReadingFragment(),"Further Reading");
        } else if (id == R.id.nav_gallery) {
            setFragment(new GalleryFragment(),"Videos");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setFragment(Fragment fragment, String title) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }

    }

    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            //     getSupportActionBar().setTitle(title);
        }

    }

}
