package org.meicode.ho_guom_explore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VisitDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitdetail);

        ImageButton vsBackBtn = findViewById(R.id.vs_back_btn);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

        vsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitDetailActivity.this, VisitActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitDetailActivity.this, VisitMapActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("buttonText");

        ImageView imageView = findViewById(R.id.img);
        TextView textView = findViewById(R.id.textview);

        if (buttonText != null) {
            switch (buttonText) {
                case "Nội dung cho nút 1":
                    imageView.setImageResource(R.drawable.visit1);
                    textView.setText("  Cầu Thê Húc với màu sơn son như một dải lụa mềm mại vắt qua làn nước xanh đặc trưng của Hồ Gươm, tạo nên vẻ đẹp hài hòa, bắt mắt. Được thần Siêu (Nguyễn Văn Siêu) xây dựng vào năm 1865. Cầu Thê Húc là một cây cầu màu đỏ son, làm bẳng gỗ, một cây cầu nối liền giữa bờ với đền Ngọc Sơn ở giữa hồ Hoàn Kiếm. Cầu Thê Húc có ý nghĩa là “nơi lưu lại ánh sáng” hay “nơi ngưng tụ hào quang”. Cầu gồm 15 nhịp, có 32 chân cột gỗ tròn xếp thành 16 đôi, mặt cầu lát ván, thành sơn màu đỏ sẫm, chữ Thê Húc được thếp vàng.");
                    break;
                case "Nội dung cho nút 2":
                    imageView.setImageResource(R.drawable.visit2);
                    textView.setText("  Đền Ngọc Sơn thuộc cụm di tích Hồ Hoàn Kiếm, là ngôi đền thờ vị anh hùng dân tộc Hưng Đạo Đại Vương Trần Quốc Tuấn và thần chủ quản công danh Văn Xương Đế Quân. Bên cạnh đó, đây cũng là nơi thờ Phật, ban Công Đồng,... Qua việc thờ cúng cùng với phong cách kiến trúc, hệ thống câu đối, hoành phi và cách bài trí của đền Ngọc Sơn đã thể hiện rõ nét quan niệm Tam giáo đồng nguyên (Phật giáo, Đạo giáo, Nho giáo) của người dân Việt Nam khi xưa.");
                    break;
                case "Nội dung cho nút 3":
                    imageView.setImageResource(R.drawable.visit3);
                    textView.setText("  Tháp Rùa là một ngọn tháp nhỏ được xây dựng trên một gò đất giữa lòng Hồ Hoàn Kiếm, rộng khoảng 350 mét vuông. Nằm ngay vị trí trung tâm của thành phố Hà Nội, sở hữu vị trí vàng như thế bất cứ ai muốn tìm đến nhìn ngắm hình ảnh Tháp Rùa cổ kính cũng đều vô cùng dễ dàng.");
                    break;
                case "Nội dung cho nút 4":
                    imageView.setImageResource(R.drawable.visit4);
                    textView.setText("  Tháp Bút ở Hồ Gươm là một ngọn tháp bằng đá cao năm tầng, được xây dựng năm Tự Đức thứ 18 (1865) trên nền núi Độc Tôn cũ theo ý tưởng của nhà nho Nguyễn Văn Siêu, nằm ở phía ngoài lối vào cầu Thê Húc, đền Ngọc Sơn.");
                    break;
                case "Nội dung cho nút 5":
                    imageView.setImageResource(R.drawable.visit5);
                    textView.setText("  Tượng đài được khởi công xây dựng ngày 17/08/2004 và khánh thành ngày 07/10/2004. Đây là bức tượng bằng đồng nguyên chất, đúc liền khối, nặng 34 tấn (tượng 14 tấn, bệ 20 tấn), cao 10,10 m (tượng cao 6,8 m, bệ cao 3,3 m). Tính theo đơn vị centimet, 1010 cm tương ứng với số năm 1010, năm khai sáng Kinh thành Thăng Long.");
                    break;
                case "Nội dung cho nút 6":
                    imageView.setImageResource(R.drawable.visit6);
                    textView.setText("  Với sức chứa 300 ghế, lại nằm ở ngay phố đi bộ Hoàn Kiếm và trung tâm thành phố Hà Nội, Nhà hát múa rối Thăng Long hội tụ nhiều tiềm năng để thu hút du khách trong và ngoài nước.");
                    break;
                default:
                    break;
            }
        }
    }
}