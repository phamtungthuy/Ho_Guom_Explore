package org.meicode.ho_guom_explore.ManageInterface.PositionManagement;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.UploadServiceActivity;
import org.meicode.ho_guom_explore.R;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class UploadPositionActivity extends AppCompatActivity {

    ImageView uploadImage;
    Button saveButton;
    EditText uploadTopic, uploadDesc, uploadAddress;
    String imageURL, audioURL;
    Uri uri;
    Button uploadSound, playSound;
    TextView textViewImage;
    Uri soundUri;
    MediaPlayer mediaPlayer;
    MediaMetadataRetriever metadataRetriever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_position);

        uploadImage = findViewById(R.id.uploadImage);
        uploadDesc = findViewById(R.id.uploadDesc);
        uploadTopic = findViewById(R.id.uploadTopic);
        uploadAddress = findViewById(R.id.uploadAddress);
        uploadSound = findViewById(R.id.uploadSound);
        saveButton = findViewById(R.id.saveButton);
//        playSound = findViewById(R.id.playSound);
        mediaPlayer = new MediaPlayer();
        textViewImage = findViewById(R.id.textViewSongsFilesSelected);

        metadataRetriever = new MediaMetadataRetriever();

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
                            Toast.makeText(UploadPositionActivity.this,
                                    "No Image Selected", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(UploadPositionActivity.this,
                                        "No Sound Selected", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(UploadPositionActivity.this,
                                    "No Sound Selected", Toast.LENGTH_SHORT).show();
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

        uploadSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soundPicker = new Intent(Intent.ACTION_GET_CONTENT);
                soundPicker.setType("audio/*");
                soundPickerLauncher.launch(soundPicker);
            }
        });

//        playSound.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mediaPlayer.isPlaying()) {
//                    mediaPlayer.pause();
//                    playSound.setText("Play Sound");
//                } else {
//                    mediaPlayer.start();
//                    playSound.setText("Pause Sound");
//                }
//            }
//        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    public void saveData() {
        String fileName = System.currentTimeMillis() + "_" + uri.getLastPathSegment();
        StorageReference imageStorageReference = FirebaseStorage.getInstance().getReference().child("Position").child("Image")
                .child(fileName);
        StorageReference audioStorageReference = FirebaseStorage.getInstance().getReference().child("Position").child("Audio")
                .child(fileName);
        AlertDialog.Builder builder = new AlertDialog.Builder(UploadPositionActivity.this);
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
                                uploadData();
                                dialog.dismiss();
                            }
                        });
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

        PositionDataClass dataClass = new PositionDataClass(title,
                desc, address, imageURL, audioURL);

        String currentDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Position").child(currentDate)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(UploadPositionActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(UploadPositionActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UploadPositionActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}