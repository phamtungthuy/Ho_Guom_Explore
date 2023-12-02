package org.meicode.ho_guom_explore.UserInterface.ServicePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventActivity;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventMapActivity;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetail;

public class ServiceActivity  extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        handleNavigationBar(findViewById(R.id.bottomNavigationView));
        ImageButton dtBackBtn = findViewById(R.id.back);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, ServiceMapActivity.class);
                startActivity(intent);
            }
        });
        TextView infoButton1 = findViewById(R.id.textView1);
        TextView infoButton2 = findViewById(R.id.textView2);
        TextView infoButton3 = findViewById(R.id.textView3);
        TextView infoButton4 = findViewById(R.id.textView4);
        TextView infoButton5 = findViewById(R.id.textView5);
        TextView infoButton6 = findViewById(R.id.textView6);
        TextView infoButton7 = findViewById(R.id.textView7);
        TextView infoButton8 = findViewById(R.id.textView8);
        ImageView InfoButton1 = findViewById(R.id.imageView1);
        ImageView InfoButton2 = findViewById(R.id.imageView2);
        ImageView InfoButton3 = findViewById(R.id.imageView3);
        ImageView InfoButton4 = findViewById(R.id.imageView4);
        ImageView InfoButton5 = findViewById(R.id.imageView5);
        ImageView InfoButton6 = findViewById(R.id.imageView6);
        ImageView InfoButton7 = findViewById(R.id.imageView7);
        ImageView InfoButton8 = findViewById(R.id.imageView8);
        View.OnClickListener infoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, ServiceDetail.class);
                String buttonText = "";
                if (v.getId() == R.id.textView1 || v.getId() == R.id.imageView1) {
                    buttonText = "Service 1";
                } else if (v.getId() == R.id.textView2 || v.getId() == R.id.imageView2) {
                    buttonText = "Service 2";
                } else if (v.getId() == R.id.textView3 || v.getId() == R.id.imageView3) {
                    buttonText = "Service 3";
                } else if (v.getId() == R.id.textView4 || v.getId() == R.id.imageView4) {
                    buttonText = "Service 4";
                } else if (v.getId() == R.id.textView5 || v.getId() == R.id.imageView5) {
                    buttonText = "Service 5";
                } else if (v.getId() == R.id.textView6 || v.getId() == R.id.imageView6) {
                    buttonText = "Service 6";
                } else if (v.getId() == R.id.textView7 || v.getId() == R.id.imageView7) {
                    buttonText = "Service 7";
                } else if (v.getId() == R.id.textView8 || v.getId() == R.id.imageView8) {
                    buttonText = "Service 8";
                }
                intent.putExtra("buttonText", buttonText);
                startActivity(intent);
            }
        };

        infoButton1.setOnClickListener(infoClickListener);
        infoButton2.setOnClickListener(infoClickListener);
        infoButton3.setOnClickListener(infoClickListener);
        infoButton4.setOnClickListener(infoClickListener);
        infoButton5.setOnClickListener(infoClickListener);
        infoButton6.setOnClickListener(infoClickListener);
        infoButton7.setOnClickListener(infoClickListener);
        infoButton8.setOnClickListener(infoClickListener);
        InfoButton1.setOnClickListener(infoClickListener);
        InfoButton2.setOnClickListener(infoClickListener);
        InfoButton3.setOnClickListener(infoClickListener);
        InfoButton4.setOnClickListener(infoClickListener);
        InfoButton5.setOnClickListener(infoClickListener);
        InfoButton6.setOnClickListener(infoClickListener);
        InfoButton7.setOnClickListener(infoClickListener);
        InfoButton8.setOnClickListener(infoClickListener);
    }

    public void backActivity() {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

};
