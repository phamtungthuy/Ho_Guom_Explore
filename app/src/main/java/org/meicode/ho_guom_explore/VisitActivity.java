package org.meicode.ho_guom_explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VisitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        ImageButton backButton = findViewById(R.id.vs_back_btn);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở bản đồ khu vực Hồ Gươm
            }
        });

        View.OnClickListener infoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitActivity.this, VisitDetailActivity.class);
                String buttonText = "";

                if (v.getId() == R.id.imageButton1) {
                    buttonText = "Nội dung cho nút 1";
                } else if (v.getId() == R.id.imageButton2) {
                    buttonText = "Nội dung cho nút 2";
                } else if (v.getId() == R.id.imageButton3) {
                    buttonText = "Nội dung cho nút 3";
                } else if (v.getId() == R.id.imageButton4) {
                    buttonText = "Nội dung cho nút 4";
                } else if (v.getId() == R.id.imageButton5) {
                    buttonText = "Nội dung cho nút 5";
                } else if (v.getId() == R.id.imageButton6) {
                    buttonText = "Nội dung cho nút 6";
                }

                intent.putExtra("buttonText", buttonText);
                startActivity(intent);
            }
        };
    }
}
