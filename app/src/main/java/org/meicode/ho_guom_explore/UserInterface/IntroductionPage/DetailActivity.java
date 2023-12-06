package org.meicode.ho_guom_explore.UserInterface.IntroductionPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        ImageButton dtBackBtn = findViewById(R.id.dt_back_btn);
        CardView dtPlayBtn = findViewById(R.id.dt_play_btn);
        Button dtBtn = findViewById(R.id.dtBtn);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        dtPlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, DetailVideoActivity.class);
                startActivity(intent);
            }
        });

        dtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });
    }
}



