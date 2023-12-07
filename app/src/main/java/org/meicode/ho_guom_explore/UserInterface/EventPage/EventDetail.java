package org.meicode.ho_guom_explore.UserInterface.EventPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventDataClass;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventDetail;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventDetailMapActivity;
import org.meicode.ho_guom_explore.UserInterface.VisitPage.VisitDetailActivity;

public class EventDetail extends BaseActivity {
    EventDataClass data;
    TextView title, description, location, startDate, endDate;
    ImageView imageBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        imageBackground = findViewById(R.id.img);
        title = findViewById(R.id.eventTittle);
        startDate = findViewById(R.id.startDate);
        endDate = findViewById(R.id.endDate);
        location = findViewById(R.id.place);
        description = findViewById(R.id.textDecription);

        ImageButton dtBackBtn = findViewById(R.id.back);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);
        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetail.this, EventActivity.class);
                startActivity(intent);
                finish();
            }
        });

        String dataTitle = getIntent().getStringExtra("title");
        String dataDescription = getIntent().getStringExtra("description");
        String dataLocation = getIntent().getStringExtra("location");
        String dataImage = getIntent().getStringExtra("image");
        String dataStartDate = getIntent().getStringExtra("startDate");
        String dataEndDate = getIntent().getStringExtra("endDate");

        title.setText(dataTitle);
        description.setText(dataDescription);
        location.setText(dataLocation);
        Glide.with(EventDetail.this).load(dataImage).into(imageBackground);
        startDate.setText(dataStartDate);
        endDate.setText(dataEndDate);


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetail.this, EventDetailMapActivity.class);
                intent.putExtra("mapUrl", "https://www.google.com/maps/place/Trung+t%C3%A2m+v%C4%83n+h%C3%B3a+qu%E1%BA%ADn+Ho%C3%A0n+Ki%E1%BA%BFm/@21.03726,105.8422574,17z/data=!4m6!3m5!1s0x3135abb9512d7945:0xa3c61fd782e05296!8m2!3d21.03726!4d105.847021!16s%2Fg%2F11c1rfmc4w?entry=ttu");
                startActivity(intent);
            }
        });

    }
}