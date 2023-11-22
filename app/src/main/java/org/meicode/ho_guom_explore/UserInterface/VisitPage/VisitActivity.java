package org.meicode.ho_guom_explore.UserInterface.VisitPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;

public class VisitActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

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
                Intent intent = new Intent(VisitActivity.this, VisitMapActivity.class);
                startActivity(intent);
            }
        });

        TextView infoButton1 = findViewById(R.id.textView1);
        TextView infoButton2 = findViewById(R.id.textView2);
        TextView infoButton3 = findViewById(R.id.textView3);
        TextView infoButton4 = findViewById(R.id.textView4);
        TextView infoButton5 = findViewById(R.id.textView5);
        TextView infoButton6 = findViewById(R.id.textView6);
        ImageView InfoButton1 = findViewById(R.id.imageView1);
        ImageView InfoButton2 = findViewById(R.id.imageView2);
        ImageView InfoButton3 = findViewById(R.id.imageView3);
        ImageView InfoButton4 = findViewById(R.id.imageView4);
        ImageView InfoButton5 = findViewById(R.id.imageView5);
        ImageView InfoButton6 = findViewById(R.id.imageView6);

        View.OnClickListener infoClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitActivity.this, VisitDetailActivity.class);
                String buttonText = "";

                if (v.getId() == R.id.textView1) {
                    buttonText = "Nội dung cho nút 1";
                } else if (v.getId() == R.id.textView2) {
                    buttonText = "Nội dung cho nút 2";
                } else if (v.getId() == R.id.textView3) {
                    buttonText = "Nội dung cho nút 3";
                } else if (v.getId() == R.id.textView4) {
                    buttonText = "Nội dung cho nút 4";
                } else if (v.getId() == R.id.textView5) {
                    buttonText = "Nội dung cho nút 5";
                } else if (v.getId() == R.id.textView6) {
                    buttonText = "Nội dung cho nút 6";
                } else if (v.getId() == R.id.imageView1) {
                    buttonText = "Nội dung cho nút 1";
                } else if (v.getId() == R.id.imageView2) {
                    buttonText = "Nội dung cho nút 2";
                } else if (v.getId() == R.id.imageView3) {
                    buttonText = "Nội dung cho nút 3";
                } else if (v.getId() == R.id.imageView4) {
                    buttonText = "Nội dung cho nút 4";
                } else if (v.getId() == R.id.imageView5) {
                    buttonText = "Nội dung cho nút 5";
                } else if (v.getId() == R.id.imageView6) {
                    buttonText = "Nội dung cho nút 6";
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
        InfoButton1.setOnClickListener(infoClickListener);
        InfoButton2.setOnClickListener(infoClickListener);
        InfoButton3.setOnClickListener(infoClickListener);
        InfoButton4.setOnClickListener(infoClickListener);
        InfoButton5.setOnClickListener(infoClickListener);
        InfoButton6.setOnClickListener(infoClickListener);

        }

    ;
}
