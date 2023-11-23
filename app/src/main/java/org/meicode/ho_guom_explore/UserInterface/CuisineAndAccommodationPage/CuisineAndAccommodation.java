package org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class CuisineAndAccommodation extends BaseActivity {

    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_and_accommodation);

        handleBackPressed(findViewById(R.id.back));

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        AlertDialog.Builder builder = new AlertDialog.Builder(CuisineAndAccommodation.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        dialog = builder.create();
        dialog.show();

        addListenerToDatabaseReference("Cuisine");
        addListenerToDatabaseReference("Restaurant");
        addListenerToDatabaseReference("Hotel");
        addListenerToDatabaseReference("Homestay");

        handleClickForwardButton(R.id.cuisine_list, "Cuisine");
        handleClickForwardButton(R.id.restaurant_list, "Restaurant");
        handleClickForwardButton(R.id.hotel_list, "Hotel");
        handleClickForwardButton(R.id.homestay_list, "Homestay");
    }

    private void addListenerToDatabaseReference(String fieldName) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(fieldName);
        List<CuisineAndAccommodationDataClass> cuisineAndAcommodationList = new ArrayList<>();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CuisineAndAccommodationDataClass cuisineData = snapshot.getValue(CuisineAndAccommodationDataClass.class);
                    cuisineAndAcommodationList.add(cuisineData);
                }

                // Sau khi lấy dữ liệu xong, cập nhật giao diện
                updateUIWithCuisineData(cuisineAndAcommodationList, fieldName);
                if(fieldName.equals("Homestay")) {
                    dialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi nếu có
            }
        });
    }

    private void updateUIWithCuisineData(List<CuisineAndAccommodationDataClass> cuisineList, String fieldName) {
        LinearLayout horizontalLayout = null;
        switch (fieldName) {
            case "Cuisine":
                horizontalLayout = findViewById(R.id.cuisine);
                break;
            case "Restaurant":
                horizontalLayout = findViewById(R.id.restaurant);
                break;
            case "Hotel":
                horizontalLayout = findViewById(R.id.hotel);
                break;
            case "Homestay":
                horizontalLayout = findViewById(R.id.homestay);
                break;
        }


        for (CuisineAndAccommodationDataClass cuisineData : cuisineList) {
            CardView cardView = new CardView(this);
            cardView.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cardView.setCardElevation(0);
            cardView.setBackgroundColor(Color.TRANSPARENT);

            LinearLayout cardLayout = new LinearLayout(this);
            cardLayout.setOrientation(LinearLayout.VERTICAL);
            cardLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT
            ));



            ImageView imageView = new ImageView(this);
            int widthInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());
            int heightInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
            int marginInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthInDp, heightInDp);
            layoutParams.setMargins(marginInDp, marginInDp, marginInDp, marginInDp);
            imageView.setLayoutParams(layoutParams);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(CuisineAndAccommodation.this).load(cuisineData.getDataImage()).into(imageView);

            // Tạo TextView
            TextView textView = new TextView(this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(marginInDp, 0, 0, 0); // Thiết lập margin bằng cách đặt giá trị padding
            textView.setText(cuisineData.getDataTitle());
            textView.setTextSize(10);

            // Thêm ImageView và TextView vào cardLayout
            cardLayout.addView(imageView);
            cardLayout.addView(textView);

            // Thêm cardLayout vào cardView
            cardView.addView(cardLayout);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CuisineAndAccommodation.this, CuisineAndAccommodationDetail.class);
                    intent.putExtra("title", cuisineData.getDataTitle());
                    intent.putExtra("description", cuisineData.getDataDescription());
                    intent.putExtra("address", cuisineData.getDataAddress());
                    intent.putExtra("image", cuisineData.getDataImage());
                    intent.putExtra("phoneNumber", cuisineData.getDataPhoneNumber());
                    intent.putExtra("website", cuisineData.getDataWebsite());
                    intent.putExtra("email", cuisineData.getDataEmail());

                    startActivity(intent);
                }
            });

            horizontalLayout.addView(cardView);

        }
    }

    public void handleClickForwardButton(int id, String fieldName) {
        ImageButton button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CuisineAndAccommodation.this, CuisineAndAccommodationList.class);
                intent.putExtra("fieldName", fieldName);
                startActivity(intent);
            }
        });

    }

}