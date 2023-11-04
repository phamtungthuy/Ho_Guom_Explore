package org.meicode.ho_guom_explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VisitDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitdetail);

        ImageButton vsBackBtn = findViewById(R.id.vs_back_btn);

        vsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitDetailActivity.this, VisitActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("buttonText");

        TextView textView = findViewById(R.id.textview);

        if (buttonText != null) {
            switch (buttonText) {
                case "Nội dung cho nút 1":
                    textView.setText("Cầu Thê Húc");
                    break;
                case "Nội dung cho nút 2":
                    textView.setText("Đền Ngọc Sơn");
                    break;
                case "Nội dung cho nút 3":
                    textView.setText("Tháp Rùa");
                    break;
                case "Nội dung cho nút 4":
                    textView.setText("Tháp Bút");
                    break;
                case "Nội dung cho nút 5":
                    textView.setText("Tượng đài Lý Thái Tổ");
                    break;
                case "Nội dung cho nút 6":
                    textView.setText("Nhà hát múa rối Thăng Long");
                    break;
                default:
                    break;
            }
        }
    }
}