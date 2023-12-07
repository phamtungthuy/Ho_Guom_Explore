package org.meicode.ho_guom_explore.UserInterface.VisitPage;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.ManageInterface.PositionManagement.PositionDataClass;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage.CuisineAndAccommodationDetail;

public class VisitDetailActivity extends BaseActivity {
    PositionDataClass data;

    TextView title, description, address;

    ImageView imageBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitdetail);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        imageBackground = findViewById(R.id.img);
        title = findViewById(R.id.dt_title);
        description = findViewById(R.id.textview);

        String dataTitle = getIntent().getStringExtra("title");
        String dataDescription = getIntent().getStringExtra("description");
        String dataAddress = getIntent().getStringExtra("address");
        String dataImage = getIntent().getStringExtra("image");

        title.setText(dataTitle);
        description.setText(dataDescription);
        Glide.with(VisitDetailActivity.this).load(dataImage).into(imageBackground);

        ImageButton vsBackBtn = findViewById(R.id.vs_back_btn);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        vsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitDetailActivity.this, VisitActivity.class);
                startActivity(intent);
                finish();
            }
        });


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitDetailActivity.this, VisitDetailMapActivity.class);
                intent.putExtra("mapUrl", "https://www.google.com/maps/search/?api=1&query=" + title.getText());
                startActivity(intent);
            }
        });

    }
}