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
    RecyclerView recycleView, recycleView2, recycleView3;
    List<CuisineAndAccommodationDataClass> dataList, dataList2, dataList3;
    DatabaseReference databaseReference, databaseReference2, databaseReference3;
    ValueEventListener eventListener, eventListener2, eventListener3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cuisine_and_accommodation);

        fab = findViewById(R.id.fab);
        recycleView = findViewById(R.id.recycleView);
        recycleView2 = findViewById(R.id.recycleView2);
        recycleView3 = findViewById(R.id.recycleView3);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(UploadCuisineAndAccommodation.this, 1);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(UploadCuisineAndAccommodation.this, 1);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(UploadCuisineAndAccommodation.this, 1);
        recycleView.setLayoutManager(gridLayoutManager);
        recycleView2.setLayoutManager(gridLayoutManager2);
        recycleView3.setLayoutManager(gridLayoutManager3);
        AlertDialog.Builder builder = new AlertDialog.Builder(UploadCuisineAndAccommodation.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList = new ArrayList<>();
        dataList2 = new ArrayList<>();
        dataList3 = new ArrayList<>();

        MyAdapter adapter = new MyAdapter(UploadCuisineAndAccommodation.this, dataList);
        MyAdapter adapter2 = new MyAdapter(UploadCuisineAndAccommodation.this, dataList2);
        MyAdapter adapter3 = new MyAdapter(UploadCuisineAndAccommodation.this, dataList3);

        recycleView.setAdapter(adapter);
        recycleView2.setAdapter(adapter2);
        recycleView3.setAdapter(adapter3);
        databaseReference = FirebaseDatabase.getInstance().getReference("Restaurant");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Cuisine");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Hotel");
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
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

        eventListener2 = databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList2.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    CuisineAndAccommodationDataClass dataClass = itemSnapshot.getValue(CuisineAndAccommodationDataClass.class);
                    dataList2.add(dataClass);
                }
                adapter2.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

        eventListener3 = databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList3.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    CuisineAndAccommodationDataClass dataClass = itemSnapshot.getValue(CuisineAndAccommodationDataClass.class);
                    dataList3.add(dataClass);
                }
                adapter3.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadCuisineAndAccommodation.this, UploadActivity.class);
                startActivity(intent);
            }
        });

    }
}