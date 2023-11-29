package org.meicode.ho_guom_explore.ManageInterface.PositionManagement;

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

import org.meicode.ho_guom_explore.R;

public class UploadPositionDetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailAddress;

    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key ="";
    String imageUrl = "";
    String audioUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_position_detail);

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
            audioUrl = bundle.getString("Audio");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Position");
                StorageReference imageStorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(imageUrl);
                StorageReference audioStorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(audioUrl);
                imageStorageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        audioStorageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child(key).removeValue();
                                Toast.makeText(UploadPositionDetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), PositionManagementActivity.class));
                                finish();
                            }
                        });
                    }
                });
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadPositionDetailActivity.this, UpdatePositionActivity.class)
                        .putExtra("Title", detailTitle.getText().toString())
                        .putExtra("Description", detailDesc.getText().toString())
                        .putExtra("Address", detailAddress.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Audio", audioUrl)
                        .putExtra("Key", key);

                startActivity(intent);
            }
        });
    }
}