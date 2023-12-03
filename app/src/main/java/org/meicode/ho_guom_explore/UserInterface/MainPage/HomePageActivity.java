package org.meicode.ho_guom_explore.UserInterface.MainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.meicode.ho_guom_explore.R;


public class HomePageActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MoreFragment moreFragment = new MoreFragment();
    HomeFragment homeFragment = new HomeFragment();

    MapFragment mapFragment = new MapFragment();

    ContactFragment contactFragment = new ContactFragment();
    NotificationFragment notificationFragment = new NotificationFragment();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        // first fragment when open app
        String id = getIntent().getStringExtra("id");
        if (id != null && !id.equals("home")) {
            if(id.equals("notification")) {
                bottomNavigationView.setSelectedItemId(R.id.menuNotification);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
            } else if(id.equals("more")) {
                bottomNavigationView.setSelectedItemId(R.id.menuMore);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();

            } else if (id.equals("map")) {
                bottomNavigationView.setSelectedItemId(R.id.menuMap);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();

            } else if (id.equals("contact")) {
                bottomNavigationView.setSelectedItemId(R.id.menuContact);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();

            } else {
                bottomNavigationView.setSelectedItemId(R.id.menuHome);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

            }
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        }



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