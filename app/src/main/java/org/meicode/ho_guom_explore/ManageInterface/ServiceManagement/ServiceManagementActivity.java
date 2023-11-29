package org.meicode.ho_guom_explore.ManageInterface.ServiceManagement;

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

import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventAdapter;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventDataClass;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.EventManagementActivity;
import org.meicode.ho_guom_explore.ManageInterface.EventManagement.UploadEventActivity;
import org.meicode.ho_guom_explore.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceManagementActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ServiceAdapter adapter;
    List<ServiceDataClass> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_management);

        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.recycleView);
        dataList = new ArrayList<>();
        adapter = new ServiceAdapter(ServiceManagementActivity.this, dataList);

        AlertDialog.Builder builder = new AlertDialog.Builder(ServiceManagementActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(ServiceManagementActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Service");

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    ServiceDataClass dataClass = itemSnapshot.getValue(ServiceDataClass.class);
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
                Intent intent = new Intent(ServiceManagementActivity.this, UploadServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}