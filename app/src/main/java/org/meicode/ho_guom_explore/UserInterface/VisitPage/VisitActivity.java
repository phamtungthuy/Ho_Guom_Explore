package org.meicode.ho_guom_explore.UserInterface.VisitPage;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.meicode.ho_guom_explore.ManageInterface.CuisineAndAccommodationManagement.CuisineAndAccommodationDataClass;
import org.meicode.ho_guom_explore.ManageInterface.PositionManagement.PositionDataClass;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage.CuisineAndAccommodation;
import org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage.CuisineAndAccommodationDetail;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;

import java.util.ArrayList;
import java.util.List;

public class VisitActivity extends BaseActivity {

    AlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        AlertDialog.Builder builder = new AlertDialog.Builder(VisitActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        dialog = builder.create();
        dialog.show();

        ImageButton backButton = findViewById(R.id.vs_back_btn);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitActivity.this, VisitMapActivity.class);
                startActivity(intent);
            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Position");
        List<PositionDataClass> positionList = new ArrayList<>();

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    PositionDataClass cuisineData = snapshot.getValue(PositionDataClass.class);
                    positionList.add(cuisineData);
                }

                // Sau khi lấy dữ liệu xong, cập nhật giao diện
                updateUI(positionList);
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý lỗi nếu có
            }
        });


        }

    private void updateUI(List<PositionDataClass> dataList) {
        LinearLayout layout = findViewById(R.id.content);


        for (PositionDataClass data : dataList) {
            CardView cardView = new CardView(this);
            cardView.setLayoutParams(new CardView.LayoutParams(
                    CardView.LayoutParams.WRAP_CONTENT,
                    CardView.LayoutParams.WRAP_CONTENT
            ));


            cardView.setCardElevation(4);
            cardView.setBackgroundColor(Color.TRANSPARENT);
            LinearLayout cardLayout = new LinearLayout(this);
            cardLayout.setOrientation(LinearLayout.HORIZONTAL);
            cardLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            int paddingInDp = convertToDp(16);
            cardLayout.setPadding(paddingInDp, paddingInDp, paddingInDp, paddingInDp);


            ImageView imageView = new ImageView(this);
            int widthInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
            int heightInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
            int marginInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthInDp, heightInDp);
//            layoutParams.setMargins(marginInDp, marginInDp, marginInDp, marginInDp);
            imageView.setLayoutParams(layoutParams);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(VisitActivity.this).load(data.getDataImage()).into(imageView);

            // Tạo TextView
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

// Đặt giá trị gravity thành center_vertical
            textViewParams.gravity = Gravity.CENTER_VERTICAL;

// Tạo một TextView và đặt LayoutParams cho nó
            TextView textView = new TextView(this);
            textView.setLayoutParams(textViewParams);
            textView.setPadding(marginInDp, 0, 0, 0); // Thiết lập margin bằng cách đặt giá trị padding
            textView.setText(data.getDataTitle());
            textView.setTextSize(18);
            textView.setTypeface(null, Typeface.BOLD);


            // Thêm ImageView và TextView vào cardLayout
            cardView.addView(imageView);

            // Thêm cardLayout vào cardView
            cardLayout.addView(cardView);
            cardLayout.addView(textView);

            cardLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(VisitActivity.this, VisitDetailActivity.class);
                    intent.putExtra("title", data.getDataTitle());
                    intent.putExtra("description", data.getDataDescription());
                    intent.putExtra("address", data.getDataAddress());
                    intent.putExtra("image", data.getDataImage());
                    intent.putExtra("audio", data.getDataAudio());

                    startActivity(intent);
                }
            });

            layout.addView(cardLayout);

            TextView barrier = new TextView(this);
            barrier.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    convertToDp(1)
            ));

            barrier.setBackgroundColor(ContextCompat.getColor(this, R.color.grey));
            layout.addView(barrier);
        }
    }
}
