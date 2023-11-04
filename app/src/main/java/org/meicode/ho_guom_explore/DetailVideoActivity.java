package org.meicode.ho_guom_explore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvideo);

        ImageButton vdBackBtn = findViewById(R.id.vd_back_btn);

        vdBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailVideoActivity.this, DetailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        VideoView videoView = findViewById(R.id.video_view);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.introHoGuom;

        Uri uri = Uri.parse(path);

        videoView.setVideoURI(uri);

        videoView.start();
    }
}