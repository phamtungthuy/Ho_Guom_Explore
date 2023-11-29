package org.meicode.ho_guom_explore.ManageInterface.PositionManagement;

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

import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.ServiceAdapter;
import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.ServiceDataClass;
import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.ServiceManagementActivity;
import org.meicode.ho_guom_explore.ManageInterface.ServiceManagement.UploadServiceActivity;
import org.meicode.ho_guom_explore.R;

import java.util.ArrayList;
import java.util.List;

public class PositionManagementActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    PositionAdapter adapter;
    List<PositionDataClass> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_management);

        fab = findViewById(R.id.fab);

        recyclerView = findViewById(R.id.recycleView);
        dataList = new ArrayList<>();
        adapter = new PositionAdapter(PositionManagementActivity.this, dataList);

        AlertDialog.Builder builder = new AlertDialog.Builder(PositionManagementActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(PositionManagementActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Position");

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    PositionDataClass dataClass = itemSnapshot.getValue(PositionDataClass.class);
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
                Intent intent = new Intent(PositionManagementActivity.this, UploadPositionActivity.class);
                startActivity(intent);
            }
        });
    }
}