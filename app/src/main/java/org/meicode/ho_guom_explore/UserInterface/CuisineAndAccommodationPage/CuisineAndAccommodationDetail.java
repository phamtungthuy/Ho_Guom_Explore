package org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;


public class CuisineAndAccommodationDetail extends BaseActivity {

    LinearLayout map;
    CuisineAndAccommodationDataClass data;

    TextView title, description, address, titleField;

    ImageView imageBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_and_accommodation_detail);
        map = findViewById(R.id.map);
        imageBackground = findViewById(R.id.image);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        address = findViewById(R.id.address);
        titleField = findViewById(R.id.titleField);

        String dataTitle = getIntent().getStringExtra("title");
        String dataDescription = getIntent().getStringExtra("description");
        String dataAddress = getIntent().getStringExtra("address");
        String dataImage = getIntent().getStringExtra("image");
        String dataPhoneNumber = getIntent().getStringExtra("phoneNumber");
        String dataWebsite = getIntent().getStringExtra("website");
        String dataEmail = getIntent().getStringExtra("email");

        handleBackPressed(findViewById(R.id.back));

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri gmmIntentUri = Uri.parse("geo:21.0285,105.8542?q=" + dataAddress);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 100);
            }
        });



        titleField.setText(dataTitle);
        title.setText(dataTitle);
        description.setText(dataDescription);
        address.setText(dataAddress);


        Glide.with(CuisineAndAccommodationDetail.this).load(dataImage).into(imageBackground);

    }
}