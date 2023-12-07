package org.meicode.ho_guom_explore.UserInterface.ServicePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.meicode.ho_guom_explore.ManageInterface.PositionManagement.PositionDataClass;
import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.ServiceDataClass;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetail;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetailMapActivity;
import org.meicode.ho_guom_explore.UserInterface.VisitPage.VisitDetailActivity;

public class ServiceDetail extends BaseActivity {
    ServiceDataClass data;

    TextView title, description, address, phoneNumber;

    ImageView imageBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        imageBackground = findViewById(R.id.img);
        title = findViewById(R.id.serviceTittle);
        address = findViewById(R.id.place);
        phoneNumber = findViewById(R.id.phone);
        description = findViewById(R.id.textDecription);

        ImageButton dtBackBtn = findViewById(R.id.back);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        String dataTitle = getIntent().getStringExtra("title");
        String dataDescription = getIntent().getStringExtra("description");
        String dataAddress = getIntent().getStringExtra("address");
        String dataImage = getIntent().getStringExtra("image");
        String dataPhoneNUmber = getIntent().getStringExtra("phoneNumber");

        title.setText(dataTitle);
        description.setText(dataDescription);
        address.setText(dataAddress);
        phoneNumber.setText(dataPhoneNUmber);
        Glide.with(ServiceDetail.this).load(dataImage).into(imageBackground);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDetail.this, ServiceActivity.class);
                startActivity(intent);
            }
        });


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDetail.this, ServiceDetailMapActivity.class);
                intent.putExtra("mapUrl", "https://www.google.com/maps/place/H%E1%BB%93+Ho%C3%A0n+Ki%E1%BA%BFm/@21.0287797,105.8497898,17z/data=!4m6!3m5!1s0x3135ab953357c995:0x1babf6bb4f9a20e!8m2!3d21.0286669!4d105.8521484!16zL20vMGdwNjV3?entry=ttu");

                startActivity(intent);
            }
        });


    }
}
