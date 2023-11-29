package org.meicode.ho_guom_explore.ManageInterface.PositionManagement;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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


import org.meicode.ho_guom_explore.R;

import java.text.DateFormat;
import java.util.Calendar;

public class UpdatePositionActivity extends AppCompatActivity {
    ImageView updateImage;
    Button updateButton, uploadAudio;
    EditText updateDesc, updateTitle, updateAddress;
    String title, desc, address;
    TextView textViewImage;
    String imageURL, audioURL;
    String key, oldImageURL, oldAudioURL;
    Uri uri, soundUri;
    DatabaseReference databaseReference;
    StorageReference imageStorageReference, audioStorageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_position);

        updateButton = findViewById(R.id.updateButton);
        updateDesc = findViewById(R.id.updateDesc);
        updateImage = findViewById(R.id.updateImage);
        updateAddress = findViewById(R.id.updateAddress);
        updateTitle = findViewById(R.id.updateTopic);
        textViewImage = findViewById(R.id.textViewSongsFilesSelected);
        uploadAudio = findViewById(R.id.uploadSound);

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
                            Toast.makeText(UpdatePositionActivity.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        ActivityResultLauncher<Intent> soundPickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            soundUri = data.getData();
                            String file_name = null;
                            if(soundUri != null) {
//                                metadataRetriever.setDataSource(GetApp, soundUri);
                                if (soundUri.getScheme().equals("content")) {
                                    Cursor cursor = getContentResolver().query(soundUri, null, null, null, null);
                                    try {
                                        if(cursor != null && cursor.moveToFirst()) {
                                            file_name = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                                        }
                                    } finally {
                                        cursor.close();
                                    }
                                }

                                if (file_name == null) {
                                    file_name = soundUri.getPath();
                                    int cut = file_name.lastIndexOf('/');
                                    if (cut != -1) {
                                        file_name = file_name.substring(cut + 1);
                                    }
                                }
                                textViewImage.setText(file_name);
                            } else {
                                Toast.makeText(UpdatePositionActivity.this,
                                        "No Sound Selected", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(UpdatePositionActivity.this,
                                    "No Sound Selected", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Glide.with(UpdatePositionActivity.this).load(bundle.getString("Image")).into(updateImage);
            updateTitle.setText(bundle.getString("Title"));
            updateDesc.setText(bundle.getString("Description"));
            updateAddress.setText(bundle.getString("Address"));
            textViewImage.setText(bundle.getString("Audio"));
            key = bundle.getString("Key");
            oldImageURL = bundle.getString("Image");
            oldAudioURL = bundle.getString("Audio");
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Position").child(key);

        updateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });

        uploadAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soundPicker = new Intent(Intent.ACTION_GET_CONTENT);
                soundPicker.setType("audio/*");
                soundPickerLauncher.launch(soundPicker);
            }
        });


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent intent = new Intent(UpdatePositionActivity.this, PositionManagementActivity.class);
                startActivity(intent);
            }
        });
    }

    public void saveData() {
        String fileName = System.currentTimeMillis() + "_" + uri.getLastPathSegment();
        imageStorageReference = FirebaseStorage.getInstance().getReference().child("Position").child("Image").child(fileName);
        audioStorageReference = FirebaseStorage.getInstance().getReference().child("Position").child("Audio").child(fileName);

        AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePositionActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);

        AlertDialog dialog = builder.create();
        dialog.show();

        imageStorageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageURL = urlImage.toString();
                audioStorageReference.putFile(soundUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while(!uriTask.isComplete());
                        Uri urlAudio = uriTask.getResult();
                        audioURL = urlAudio.toString();
                        updateData();
                        dialog.dismiss();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdatePositionActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
    public void updateData() {
        title = updateTitle.getText().toString();
        desc = updateDesc.getText().toString();
        address = updateAddress.getText().toString();


        PositionDataClass dataClass = new PositionDataClass(title,
                desc, address,imageURL, audioURL);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    StorageReference imageReference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL);
                    StorageReference audioReference = FirebaseStorage.getInstance().getReferenceFromUrl(oldAudioURL);
                    imageReference.delete();
                    audioReference.delete();

                    Toast.makeText(UpdatePositionActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpdatePositionActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}