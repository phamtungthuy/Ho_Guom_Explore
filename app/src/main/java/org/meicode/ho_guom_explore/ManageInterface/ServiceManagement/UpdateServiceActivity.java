package org.meicode.ho_guom_explore.ManageInterface.ServiceManagement;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventDataClass;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventManagementActivity;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.UpdateEventActivity;
import org.meicode.ho_guom_explore.R;

import java.text.DateFormat;
import java.util.Calendar;

public class UpdateServiceActivity extends AppCompatActivity {

    ImageView updateImage;
    Button updateButton;
    EditText updateDesc, updateTitle, updateAddress, updatePhoneNumber, updateWebsite, updateEmail;
    String title, desc, address, phoneNumber, website, email;
    String imageUrl;
    String key, oldImageURL;
    Uri uri;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_service);

        updateButton = findViewById(R.id.updateButton);
        updateDesc = findViewById(R.id.updateDesc);
        updateImage = findViewById(R.id.updateImage);
        updateAddress = findViewById(R.id.updateAddress);
        updateTitle = findViewById(R.id.updateTopic);
        updateWebsite = findViewById(R.id.updateWebsite);
        updateEmail = findViewById(R.id.updateEmail);
        updatePhoneNumber = findViewById(R.id.updatePhoneNumber);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            updateImage.setImageURI(uri);
                        } else {
                            Toast.makeText(UpdateServiceActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Glide.with(UpdateServiceActivity.this).load(bundle.getString("Image")).into(updateImage);
            updateTitle.setText(bundle.getString("Title"));
            updateDesc.setText(bundle.getString("Description"));
            updateAddress.setText(bundle.getString("Address"));
            key = bundle.getString("Key");
            oldImageURL = bundle.getString("Image");
            updateEmail.setText(bundle.getString("Email"));
            updateWebsite.setText(bundle.getString("Website"));
            updatePhoneNumber.setText(bundle.getString("Phone Number"));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Service").child(key);

        updateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent = new Intent(UpdateServiceActivity.this, ServiceManagementActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveData() {
        String fileName = System.currentTimeMillis() + "_" + uri.getLastPathSegment();
        storageReference = FirebaseStorage.getInstance().getReference().child("Service").child(fileName);


        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateServiceActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);

        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                updateData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateServiceActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
    public void updateData() {
        title = updateTitle.getText().toString();
        desc = updateDesc.getText().toString();
        address = updateAddress.getText().toString();
        phoneNumber = updatePhoneNumber.getText().toString();
        website = updateWebsite.getText().toString();
        email = updateEmail.getText().toString();


        ServiceDataClass dataClass = new ServiceDataClass(title,
                desc, address,imageUrl, phoneNumber, website, email);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    StorageReference reference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL);
                    reference.delete();
                    Toast.makeText(UpdateServiceActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdateServiceActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}