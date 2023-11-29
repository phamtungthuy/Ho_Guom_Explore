package org.meicode.ho_guom_explore.ManageInterface.ServiceManagement;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UploadActivity;
import org.meicode.ho_guom_explore.R;

import java.text.DateFormat;
import java.util.Calendar;

public class UploadServiceActivity extends AppCompatActivity {

    ImageView uploadImage;
    Button saveButton;
    EditText uploadTopic, uploadDesc, uploadAddress, uploadPhoneNumber, uploadWebsite, uploadEmail;
    String imageURL;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_service);
        uploadImage = findViewById(R.id.uploadImage);
        uploadDesc = findViewById(R.id.uploadDesc);
        uploadTopic = findViewById(R.id.uploadTopic);
        uploadAddress = findViewById(R.id.uploadAddress);
        uploadPhoneNumber =findViewById(R.id.uploadPhoneNumber);
        uploadWebsite = findViewById(R.id.uploadWebsite);
        uploadEmail = findViewById(R.id.uploadEmail);

        saveButton = findViewById(R.id.saveButton);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            uri = data.getData();
                            uploadImage.setImageURI(uri);
                        } else {
                            Toast.makeText(UploadServiceActivity.this,
                                    "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }
    public void saveData() {
        String fileName = System.currentTimeMillis() + "_" + uri.getLastPathSegment();
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Service")
                .child(fileName);

        AlertDialog.Builder builder = new AlertDialog.Builder(UploadServiceActivity.this);
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
                        imageURL = urlImage.toString();
                        uploadData();
                        dialog.dismiss();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                    }
                });
    }
    public void uploadData() {
        String title = uploadTopic.getText().toString();
        String desc = uploadDesc.getText().toString();
        String address = uploadAddress.getText().toString();
        String phoneNumber = uploadPhoneNumber.getText().toString();
        String website = uploadWebsite.getText().toString();
        String email = uploadEmail.getText().toString();


        CuisineAndAccommodationDataClass dataClass = new CuisineAndAccommodationDataClass(title,
                desc, address, imageURL, phoneNumber, website, email);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Service").child(currentDate)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(UploadServiceActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(UploadServiceActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadServiceActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}