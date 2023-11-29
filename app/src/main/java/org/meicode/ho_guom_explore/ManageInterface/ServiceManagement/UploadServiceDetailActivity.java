package org.meicode.ho_guom_explore.ManageInterface.ServiceManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UpdateActivity;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UploadDetailActivity;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventManagementActivity;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.UpdateEventActivity;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.UploadEventDetailActivity;
import org.meicode.ho_guom_explore.R;

public class UploadServiceDetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailAddress, detailPhoneNumber, detailWebsite, detailEmail;

    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key ="";
    String imageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_service_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.deleteButton);
        detailAddress = findViewById(R.id.detailAddress);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailAddress.setText(bundle.getString("Address"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Service");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);

                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(UploadServiceDetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), ServiceManagementActivity.class));
                        finish();
                    }
                });
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadServiceDetailActivity.this, UpdateServiceActivity.class)
                        .putExtra("Title", detailTitle.getText().toString())
                        .putExtra("Description", detailDesc.getText().toString())
                        .putExtra("Address", detailAddress.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Phone Number", bundle.getString("Phone Number"))
                        .putExtra("Website", bundle.getString("Website"))
                        .putExtra("Email", bundle.getString("Email"))
                        .putExtra("Key", key);

                startActivity(intent);
            }
        });

    }
}