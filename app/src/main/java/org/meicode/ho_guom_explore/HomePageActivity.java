package org.meicode.ho_guom_explore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.meicode.ho_guom_explore.databinding.ActivityMainBinding;

public class HomePageActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MoreFragment moreFragment = new MoreFragment();
    HomeFragment homeFragment = new HomeFragment();

    MapFragment mapFragment = new MapFragment();

    ContactFragment contactFragment = new ContactFragment();
    NotificationFragment notificationFragment = new NotificationFragment();

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Check the ID of the selected MenuItem to determine which item is selected

                if(item.getItemId() == R.id.menuHome){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                }

                if(item.getItemId() == R.id.menuMore){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();
                    return true;
                }

                if(item.getItemId() == R.id.menuNotification){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
                    return true;
                }

                if(item.getItemId() == R.id.menuContact){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
                    return true;
                }

                if(item.getItemId() == R.id.menuMap){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
                    return true;
                }

                return false; // Return false if the event is not handled
            }
        });
    }
}