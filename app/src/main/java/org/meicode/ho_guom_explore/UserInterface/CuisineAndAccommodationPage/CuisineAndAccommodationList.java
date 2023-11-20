package org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CuisineAndAccommodationList extends BaseActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_and_accommodation_list);

        title = findViewById(R.id.title);

        handleBackPressed(findViewById(R.id.back));
        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        String fieldName = getIntent().getStringExtra("fieldName");

        AlertDialog.Builder builder = new AlertDialog.Builder(CuisineAndAccommodationList.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(fieldName);
        List<CuisineAndAccommodationDataClass> dataList = new ArrayList<>();


        switch (fieldName) {
            case "Cuisine":
                title.setText("Đặc Sản");
                break;
            case "Restaurant":
                title.setText("Nhà Hàng");
                break;
            case "Hotel":
                title.setText("Khách Sạn");
                break;
            case "Homestay":
                title.setText("Homestay");
                break;
        }

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CuisineAndAccommodationDataClass cuisineData = snapshot.getValue(CuisineAndAccommodationDataClass.class);
                    dataList.add(cuisineData);
                }

                // Sau khi lấy dữ liệu xong, cập nhật giao diện
                loadHorizontalData(dataList);
                loadVerticalData(dataList);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi nếu có
            }
        });
    }

    public void loadHorizontalData(List<CuisineAndAccommodationDataClass> dataList) {

        LinearLayout horizontalLayout = findViewById(R.id.horizontal_list);

        for(CuisineAndAccommodationDataClass data : dataList) {
            CardView cardView = new CardView(this);
            cardView.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cardView.setCardElevation(0);

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
            Glide.with(CuisineAndAccommodationList.this).load(data.getDataImage()).into(imageView);

            TextView textView = new TextView(this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(marginInDp, 0, 0, 0); // Thiết lập margin bằng cách đặt giá trị padding
            textView.setText(data.getDataTitle());
            textView.setTextSize(10);

            cardLayout.addView(imageView);
            cardLayout.addView(textView);

            // Thêm cardLayout vào cardView
            cardView.addView(cardLayout);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CuisineAndAccommodationList.this, CuisineAndAccommodationDetail.class);
                    intent.putExtra("title", data.getDataTitle());
                    intent.putExtra("description", data.getDataDescription());
                    intent.putExtra("address", data.getDataAddress());
                    intent.putExtra("image", data.getDataImage());
                    intent.putExtra("phoneNumber", data.getDataPhoneNumber());
                    intent.putExtra("website", data.getDataWebsite());
                    intent.putExtra("email", data.getDataEmail());

                    startActivity(intent);
                }
            });


            horizontalLayout.addView(cardView);
        }
    }

    public int convertToDp(int n) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, getResources().getDisplayMetrics());
    }

    public void loadVerticalData(List<CuisineAndAccommodationDataClass> dataList) {
        LinearLayout verticalLayout = findViewById(R.id.vertical_list);
        int count = 0;
        for(CuisineAndAccommodationDataClass data : dataList) {
            if (count > 0 && count < dataList.size()) {

                TextView textView = new TextView(this);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        convertToDp(2)
                );
                params.setMargins(0, convertToDp(10), 0, 0);

                textView.setLayoutParams(params);
                textView.setPadding(10, 10, 10, 10);

                textView.setBackgroundColor(getResources().getColor(R.color.grey));
                verticalLayout.addView(textView);
            }

            CardView cardView = new CardView(this);

            cardView.setLayoutParams(new CardView.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            cardView.setCardElevation(0);


            LinearLayout cardLayout = new LinearLayout(this);
            cardLayout.setOrientation(LinearLayout.VERTICAL);
            cardLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT
            ));
            cardLayout.setOrientation(LinearLayout.HORIZONTAL);
            cardLayout.setGravity(Gravity.CENTER_VERTICAL);

            ImageView imageView = new ImageView(this);
            int widthInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics());
            int heightInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics());
            int marginInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthInDp, heightInDp);
            layoutParams.setMargins(0, marginInDp, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(CuisineAndAccommodationList.this).load(data.getDataImage()).into(imageView);

            TextView textView = new TextView(this);
            textView.setLayoutParams(new ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(marginInDp * 2, 0, 0, 0); // Thiết lập margin bằng cách đặt giá trị padding
            textView.setText(data.getDataTitle());

            cardLayout.addView(imageView);
            cardLayout.addView(textView);

            // Thêm cardLayout vào cardView
            cardView.addView(cardLayout);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CuisineAndAccommodationList.this, CuisineAndAccommodationDetail.class);
                    intent.putExtra("title", data.getDataTitle());
                    intent.putExtra("description", data.getDataDescription());
                    intent.putExtra("address", data.getDataAddress());
                    intent.putExtra("image", data.getDataImage());
                    intent.putExtra("phoneNumber", data.getDataPhoneNumber());
                    intent.putExtra("website", data.getDataWebsite());
                    intent.putExtra("email", data.getDataEmail());

                    startActivity(intent);
                }
            });


            verticalLayout.addView(cardView);
            count += 1;
        }
    }
}