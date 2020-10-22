package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl=(DrawerLayout)findViewById(R.id.drawer);
        adt= new ActionBarDrawerToggle(this, dl, R.string.open,R.string.close);
        adt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(adt);
        adt.syncState();

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if( id== R.id.home){
                    Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return adt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}