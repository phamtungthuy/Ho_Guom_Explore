package org.meicode.ho_guom_explore.ManageInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UploadCuisineAndAccommodation;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventManagementActivity;
import org.meicode.ho_guom_explore.R;

public class ManagementActivity extends AppCompatActivity {

    CardView introduction, position, event, service, cuisineAndAccommodation, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        introduction = findViewById(R.id.introduction);
        position = findViewById(R.id.position);
        event = findViewById(R.id.event);
        service = findViewById(R.id.service);
        cuisineAndAccommodation = findViewById(R.id.cuisineAndAccommodation);
        comment = findViewById(R.id.comment);

        handleClickButton(introduction, "introduction");
        handleClickButton(position, "position");
        handleClickButton(event, "event");
        handleClickButton(service, "service");
        handleClickButton(cuisineAndAccommodation, "cuisine");
        handleClickButton(comment, "comment");
    }

    public void handleClickButton(CardView cardView, String fieldName) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch (fieldName) {
                    case "cuisine":
                        intent = new Intent(ManagementActivity.this, UploadCuisineAndAccommodation.class);
                        break;
                    case "event":
                        intent = new Intent(ManagementActivity.this, EventManagementActivity.class);
                        break;
                }
                if(intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}