package org.meicode.ho_guom_explore.UserInterface.ServicePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetail;

public class ServiceActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ImageButton dtBackBtn = findViewById(R.id.back);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
        Button detailButton1 = findViewById(R.id.s_button1);
        Button detailButton2 = findViewById(R.id.s_button2);
        Button detailButton3 = findViewById(R.id.s_button3);
        Button detailButton4 = findViewById(R.id.s_button4);
        Button detailButton5 = findViewById(R.id.s_button5);
        Button detailButton6 = findViewById(R.id.s_button6);
        Button detailButton7 = findViewById(R.id.s_button7);
        Button detailButton8 = findViewById(R.id.s_button8);
        View.OnClickListener infoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, ServiceDetail.class);
                String buttonText = "";
                if (v.getId() == R.id.s_button1) {
                    buttonText = "Service 1";
                } else if (v.getId() == R.id.s_button2) {
                    buttonText = "Service 2";
                } else if (v.getId() == R.id.s_button3) {
                    buttonText = "Service 3";
                } else if (v.getId() == R.id.s_button4) {
                    buttonText = "Service 4";
                } else if (v.getId() == R.id.s_button5) {
                    buttonText = "Service 5";
                } else if (v.getId() == R.id.s_button6) {
                    buttonText = "Service 6";
                } else if (v.getId() == R.id.s_button7) {
                    buttonText = "Service 7";
                } else if (v.getId() == R.id.s_button8) {
                    buttonText = "Service 8";
                }
                intent.putExtra("buttonText", buttonText);
                startActivity(intent);
            }
        };

        detailButton1.setOnClickListener(infoClickListener);
        detailButton2.setOnClickListener(infoClickListener);
        detailButton3.setOnClickListener(infoClickListener);
        detailButton4.setOnClickListener(infoClickListener);
        detailButton5.setOnClickListener(infoClickListener);
        detailButton6.setOnClickListener(infoClickListener);
        detailButton7.setOnClickListener(infoClickListener);
        detailButton8.setOnClickListener(infoClickListener);
    }

    public void backActivity() {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

};
