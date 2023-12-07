package org.meicode.ho_guom_explore.UserInterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.ContactFragment;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomeFragment;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;
import org.meicode.ho_guom_explore.UserInterface.MainPage.MapFragment;
import org.meicode.ho_guom_explore.UserInterface.MainPage.MoreFragment;
import org.meicode.ho_guom_explore.UserInterface.MainPage.NotificationFragment;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }



    public void handleNavigationBar(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setSelectedItemId(R.id.menuHome);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Check the ID of the selected MenuItem to determine which item is selected

                String id = null;

                if(item.getItemId() == R.id.menuHome) {
                    id = "home";
                } else if(item.getItemId() == R.id.menuMore){
                    id = "more";
                } else if(item.getItemId() == R.id.menuNotification){
                    id = "notification";
                } else if(item.getItemId() == R.id.menuContact){
                    id = "contact";
                } else if(item.getItemId() == R.id.menuMap){
                    id = "map";
                }
                Intent intent = new Intent(BaseActivity.this, HomePageActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                return false;
            }
        });

    }

    public void handleBackPressed(ImageButton back) {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý khi nút back được click
                onBackPressed();
            }
        });
    }

    public int convertToDp(int n) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, getResources().getDisplayMetrics());
    }

    public int convertToSp(int n) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, n, getResources().getDisplayMetrics());
    }
}