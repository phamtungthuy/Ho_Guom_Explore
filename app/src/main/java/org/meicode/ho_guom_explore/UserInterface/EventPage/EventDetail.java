package org.meicode.ho_guom_explore.UserInterface.EventPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.meicode.ho_guom_explore.R;

public class EventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ImageButton dtBackBtn = findViewById(R.id.back);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetail.this, EventActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("buttonText");

        ImageView imageView = findViewById(R.id.img);
        TextView eventTittle = findViewById(R.id.eventTittle);
        TextView startDate = findViewById(R.id.startDate);
        TextView endDate = findViewById(R.id.endDate);
        TextView place = findViewById(R.id.place);
        TextView textDecription = findViewById(R.id.textDecription);


        if (buttonText != null) {
            switch (buttonText) {
                case "Event 1":
                    imageView.setImageResource(R.drawable.event_1);
                    eventTittle.setText("Sinh hoạt CLB cờ Hồ Gươm");
                    startDate.setText("22/10/2023");
                    endDate.setText("27/10/2023");
                    place.setText("Trung tâm thông tin văn hóa Hồ Gươm");
                    textDecription.setText("   Hoạt động giao lưu chơi cờ, cung cấp nơi vui chơi cho " +
                            "các bạn học sinh những ngày cuối tuần.");
                    break;
                case "Event 2":
                    imageView.setImageResource(R.drawable.event_2);
                    eventTittle.setText("Biểu diễn các trích đoạn vở diễn, kịch ngắn");
                    startDate.setText("21/10/2023");
                    endDate.setText("22/10/2023");
                    place.setText("Khu vực trước cửa Rạp Công nhân - 42 phố Tràng Tiền");
                    textDecription.setText("   Biểu diễn những trích đoạn bất hủ, qua đó giúp giữ " +
                            "gìn những nét đẹp của phố đi bộ.");
                    break;
                case "Event 3":
                    imageView.setImageResource(R.drawable.event_3);
                    eventTittle.setText("Trò chơi dân gian");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Ngã 3 Đinh Tiên Hoàng - Hàng Dầu (trước cửa Sở VH&TT)");
                    textDecription.setText("   Tổ chức các hoạt động trò chơi dân gian, phù hợp mọi " +
                            "lứa tuổi. Phụ huynh có thể cho các em tới chơi vào dịp lễ, cuối tuần.");
                    break;
                case "Event 4":
                    imageView.setImageResource(R.drawable.event_4);
                    eventTittle.setText("Trò chơi thông minh");
                    startDate.setText("10/11/2023");
                    endDate.setText("12/11/2023");
                    place.setText("Vỉa hè Bưu điện Hà Nội (đối diện tháp Hòa Phong)");
                    textDecription.setText("   Các bạn trẻ khi tới sự kiện này sẽ được tiếp xúc với " +
                            "các trò chơi kiểu mới. Từ những trò chơi này, các em sẽ học được cách " +
                            "làm việc thông minh và có trách nhiệm với nhóm mà mình tham gia.");
                    break;
                case "Event 5":
                    imageView.setImageResource(R.drawable.event_5);
                    eventTittle.setText("Các cửa hàng sách");
                    startDate.setText("10/11/2023");
                    endDate.setText("12/11/2023");
                    place.setText("Phố sách Đinh Lễ - Nguyễn Xí");
                    textDecription.setText("   Đây là điểm hẹn lý tưởng với các bạn đọc yêu thích " +
                            "việc đọc sách. Các loại sách được đưa về trong lần này sẽ bao gồm thể " +
                            "loại lịch sử và sách sinh thái học của Việt Nam.");
                    break;
                case "Event 6":
                    imageView.setImageResource(R.drawable.event_6);
                    eventTittle.setText("Biểu diễn hát xẩm, hát dân gian, chèo");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Sân khấu mặt trước đền Bà Kiệu");
                    textDecription.setText("   Hoạt động thường xuyên của sân khấu, đem lại cho " +
                            "khán thính giả cảm nhận về âm nhạc quê hương.");
                    break;
                case "Event 7":
                    imageView.setImageResource(R.drawable.event_7);
                    eventTittle.setText("Biểu diễn ca nhạc, rối");
                    startDate.setText("11/11/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Trước cửa nhà hát múa rối Thăng Long");
                    textDecription.setText("   Đến hẹn lại lên, các tiết mục văn nghệ phục vụ đối " +
                            "tượng trẻ em luôn được các cô chú nghệ sĩ thuộc nhà hát múa rối Thăng " +
                            "Long đem lại. Sôi động, hào hứng và đầy sức sống, kính mời các khán giả " +
                            "vào cuối tuần!");
                    break;
                case "Event 8":
                    imageView.setImageResource(R.drawable.event_8);
                    eventTittle.setText("Chương trình nghệ thuật truyền thống");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Khu vực đồng hồ Hoa Thụy Sĩ");
                    textDecription.setText("   Sự kiện thường trực, mang đến cho người xem vẻ đẹp " +
                            "nghệ thuật truyền thống quen thuộc mà sâu lắng!");
                    break;
                case "Event 9":
                    imageView.setImageResource(R.drawable.event_9);
                    eventTittle.setText("Chương trình nghệ thuật truyền thống kiểu mới");
                    startDate.setText("13/11/2023");
                    endDate.setText("13/12/2023");
                    place.setText("Trung tâm Thông tin văn hóa Hồ Gươm");
                    textDecription.setText("   Những ca khúc truyền thống, nhưng nay được lớp trẻ " +
                            "biểu diễn. Các bạn khán giả hãy tới ủng hộ và thưởng thức sự mới mẻ " +
                            "mà chúng tôi mang lại.");
                    break;
                case "Event 10":
                    imageView.setImageResource(R.drawable.event_10);
                    eventTittle.setText("Biểu diễn âm nhạc truyền thống");
                    startDate.setText("13/11/2023");
                    endDate.setText("13/12/2023");
                    place.setText("Khu vực không gian Quảng trường Đông Kinh Nghĩa Thục");
                    textDecription.setText("   Trải nghiệm văn hóa bản sắc các vùng miền phía Bắc. " +
                            "Không gian và đội ngũ chuyên nghiệp sẽ đem đến các tiết mục xứng đáng với " +
                            "công sức bạn tới xem.");
                    break;
                default:
                    break;
            }
        }
    }
}