package org.meicode.ho_guom_explore.ManageInterface;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

import org.meicode.ho_guom_explore.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UploadCuisineAndAccommodation extends AppCompatActivity {

    FloatingActionButton fab;
    List<RecyclerView> recyclerViewList;
    final List<String> fieldList = new ArrayList<String>(Arrays.asList("Cuisine", "Restaurant", "Hotel", "Homestay"));

    List<MyAdapter> adapterList;
    List<List<CuisineAndAccommodationDataClass>> dataLists;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cuisine_and_accommodation);

        fab = findViewById(R.id.fab);
        adapterList = new ArrayList<>();
        dataLists = new ArrayList<>();
        recyclerViewList = new ArrayList<>();
        recyclerViewList.add(findViewById(R.id.recycleView));
        recyclerViewList.add(findViewById(R.id.recycleView2));
        recyclerViewList.add(findViewById(R.id.recycleView3));
        recyclerViewList.add(findViewById(R.id.recycleView4));

        searchView = findViewById(R.id.search);
        searchView.clearFocus();

        AlertDialog.Builder builder = new AlertDialog.Builder(UploadCuisineAndAccommodation.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        for(int i = 0; i < fieldList.size(); i++) {
            dataLists.add(new ArrayList<CuisineAndAccommodationDataClass>());
            adapterList.add(new MyAdapter(UploadCuisineAndAccommodation.this, dataLists.get(i)));
            handleLoadData(i, dialog);
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
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

    private void handleLoadData(int index, AlertDialog dialog) {
        RecyclerView recyclerView = recyclerViewList.get(index);
        final MyAdapter adapter = adapterList.get(index);
        String fieldName = fieldList.get(index);
        List<CuisineAndAccommodationDataClass> dataList = dataLists.get(index);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(UploadCuisineAndAccommodation.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(fieldName);
        dialog.show();


        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    CuisineAndAccommodationDataClass dataClass = itemSnapshot.getValue(CuisineAndAccommodationDataClass.class);
                    dataClass.setKey(itemSnapshot.getKey());
                    dataClass.setFieldName(fieldName);
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

    public void searchList(String text) {
        for(int i = 0; i < fieldList.size(); i++) {
            List<CuisineAndAccommodationDataClass> dataList = dataLists.get(i);
            MyAdapter adapter = adapterList.get(i);
            ArrayList<CuisineAndAccommodationDataClass> searchList = new ArrayList<>();
            for (CuisineAndAccommodationDataClass dataClass : dataList) {
                if (dataClass.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                    searchList.add(dataClass);
                }
            }
            adapter.searchDataList(searchList);
        }


    }
}

