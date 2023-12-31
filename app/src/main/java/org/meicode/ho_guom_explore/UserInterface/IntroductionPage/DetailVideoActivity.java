package org.meicode.ho_guom_explore.UserInterface.IntroductionPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.MediaController;
import android.media.MediaPlayer;

import org.meicode.ho_guom_explore.UserInterface.BaseActivity;

import org.meicode.ho_guom_explore.R;

public class DetailVideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailvideo);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

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


        String path = "android.resource://" + getPackageName() + "/" + R.raw.intro;

        Uri uri = Uri.parse(path);

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        videoView.start();

    }
}