package org.meicode.ho_guom_explore.ManageInterface.EventManagement;

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

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UploadActivity;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.UploadCuisineAndAccommodation;
import org.meicode.ho_guom_explore.R;

import java.util.ArrayList;
import java.util.List;

public class EventManagementActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    EventAdapter adapter;
    List<EventDataClass> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_management);

        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.recycleView);
        dataList = new ArrayList<>();
        adapter = new EventAdapter(EventManagementActivity.this, dataList);

        AlertDialog.Builder builder = new AlertDialog.Builder(EventManagementActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(EventManagementActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Event");

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    EventDataClass dataClass = itemSnapshot.getValue(EventDataClass.class);
                    dataClass.setKey(itemSnapshot.getKey());
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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventManagementActivity.this, UploadEventActivity.class);
                startActivity(intent);
            }
        });
    }
}