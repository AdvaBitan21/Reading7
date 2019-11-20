package com.reading7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }



    public boolean loadFragment(Fragment fragment){

        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmant_container, fragment)
                    .addToBackStack(fragment.getClass().toString())
                    .commit();
            return true;
        }

        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        int index = getSupportFragmentManager().getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);

        switch (menuItem.getItemId()){

            case R.id.navigation_home:
                if(backEntry.getName().equals("class com.reading7.HomeFragment"))
                    return true;
                fragment = new HomeFragment();
                break;

            case R.id.navigation_explore:
                if(backEntry.getName().equals("class com.reading7.ExploreFragment"))
                    return true;
                fragment = new ExploreFragment();
                break;

            case R.id.navigation_profile:
                if(backEntry.getName().equals("class com.reading7.ProfileFragment"))
                    return true;
                fragment = new ProfileFragment();
                break;
        }

        return loadFragment(fragment);
    }


}