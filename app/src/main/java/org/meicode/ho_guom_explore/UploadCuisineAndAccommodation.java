package org.meicode.ho_guom_explore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UploadCuisineAndAccommodation extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recycleView, recycleView2, recycleView3, recyclerView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cuisine_and_accommodation);

        fab = findViewById(R.id.fab);
        recycleView = findViewById(R.id.recycleView);
        recycleView2 = findViewById(R.id.recycleView2);
        recycleView3 = findViewById(R.id.recycleView3);
        recyclerView4 = findViewById(R.id.recycleView4);

        AlertDialog.Builder builder = new AlertDialog.Builder(UploadCuisineAndAccommodation.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        handleLoadData("Cuisine", dialog, recycleView);
        handleLoadData("Restaurant", dialog, recycleView2);
        handleLoadData("Hotel", dialog, recycleView3);
        handleLoadData("Homestay", dialog, recyclerView4);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadCuisineAndAccommodation.this, UploadActivity.class);
                startActivity(intent);
            }
        });

    }

    private void handleLoadData(String fieldName, AlertDialog dialog, RecyclerView recView) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(UploadCuisineAndAccommodation.this, 1);
        recView.setLayoutManager(gridLayoutManager);
        List<CuisineAndAccommodationDataClass> dataList = new ArrayList<>();
        MyAdapter adapter = new MyAdapter(UploadCuisineAndAccommodation.this, dataList);
        recView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(fieldName);
        dialog.show();


        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    CuisineAndAccommodationDataClass dataClass = itemSnapshot.getValue(CuisineAndAccommodationDataClass.class);
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });
    }
}

