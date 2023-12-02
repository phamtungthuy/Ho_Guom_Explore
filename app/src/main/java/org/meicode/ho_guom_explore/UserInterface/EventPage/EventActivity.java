package org.meicode.ho_guom_explore.UserInterface.EventPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventDetail;

public class EventActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ImageButton dtBackBtn = findViewById(R.id.back);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
        Button detailButton1 = findViewById(R.id.e_button1);
        Button detailButton2 = findViewById(R.id.e_button2);
        Button detailButton3 = findViewById(R.id.e_button3);
        Button detailButton4 = findViewById(R.id.e_button4);
        Button detailButton5 = findViewById(R.id.e_button5);
        Button detailButton6 = findViewById(R.id.e_button6);
        Button detailButton7 = findViewById(R.id.e_button7);
        Button detailButton8 = findViewById(R.id.e_button8);
        Button detailButton9 = findViewById(R.id.e_button9);
        Button detailButton10 = findViewById(R.id.e_button10);
        View.OnClickListener infoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, EventDetail.class);
                String buttonText = "";
                if (v.getId() == R.id.e_button1) {
                    buttonText = "Event 1";
                } else if (v.getId() == R.id.e_button2) {
                    buttonText = "Event 2";
                } else if (v.getId() == R.id.e_button3) {
                    buttonText = "Event 3";
                } else if (v.getId() == R.id.e_button4) {
                    buttonText = "Event 4";
                } else if (v.getId() == R.id.e_button5) {
                    buttonText = "Event 5";
                } else if (v.getId() == R.id.e_button6) {
                    buttonText = "Event 6";
                } else if (v.getId() == R.id.e_button7) {
                    buttonText = "Event 7";
                } else if (v.getId() == R.id.e_button8) {
                    buttonText = "Event 8";
                } else if (v.getId() == R.id.e_button9) {
                    buttonText = "Event 9";
                } else if (v.getId() == R.id.e_button10) {
                    buttonText = "Event 10";
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
        detailButton9.setOnClickListener(infoClickListener);
        detailButton10.setOnClickListener(infoClickListener);
    }
    public void backActivity() {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
};



