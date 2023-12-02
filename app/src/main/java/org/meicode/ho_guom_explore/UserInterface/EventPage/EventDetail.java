package org.meicode.ho_guom_explore.UserInterface.EventPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventDetail;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventDetailMapActivity;

public class EventDetail extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ImageButton dtBackBtn = findViewById(R.id.back);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);

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
        TextView header = findViewById(R.id.title);

        ImageView imageView = findViewById(R.id.img);
        TextView eventTittle = findViewById(R.id.eventTittle);
        TextView startDate = findViewById(R.id.startDate);
        TextView endDate = findViewById(R.id.endDate);
        TextView place = findViewById(R.id.place);
        TextView textDecription = findViewById(R.id.textDecription);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetail.this, EventDetailMapActivity.class);
                if (header.getText().toString().equals("Cờ Hồ Gươm")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Trung+t%C3%A2m+v%C4%83n+h%C3%B3a+qu%E1%BA%ADn+Ho%C3%A0n+Ki%E1%BA%BFm/@21.03726,105.8422574,17z/data=!4m6!3m5!1s0x3135abb9512d7945:0xa3c61fd782e05296!8m2!3d21.03726!4d105.847021!16s%2Fg%2F11c1rfmc4w?entry=ttu");
                } else if (header.getText().toString().equals("Biểu diễn vở diễn ngắn")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/R%E1%BA%A1p+C%C3%B4ng+Nh%C3%A2n/@21.0254081,105.8518457,17.17z/data=!4m6!3m5!1s0x3135abeb703eaa7b:0x80f9ab6cfd801f00!8m2!3d21.0252687!4d105.8547863!16s%2Fg%2F1v8ky1xk?entry=ttu");
                } else if (header.getText().toString().equals("Trò chơi dân gian")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/P.+H%C3%A0ng+D%E1%BA%A7u,+L%C3%BD+Th%C3%A1i+T%E1%BB%95,+Ho%C3%A0n+Ki%E1%BA%BFm,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@21.0312845,105.8490552,17z/data=!3m1!4b1!4m10!1m2!2m1!1zTmfDoyAzIMSQaW5oIFRpw6puIEhvw6BuZyAtIEjDoG5nIEThuqd1!3m6!1s0x3135abc016332ac1:0xb8b76bf261a2e85!8m2!3d21.0312796!4d105.8539261!15sCidOZ8OjIDMgxJBpbmggVGnDqm4gSG_DoG5nIC0gSMOgbmcgROG6p3WSAQ5ub3RhYmxlX3N0cmVldOABAA!16s%2Fg%2F1tlw6k0j?entry=ttu");
                } else if (header.getText().toString().equals("Trò chơi thông minh")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/B%C6%B0u+%C4%90i%E1%BB%87n+H%C3%A0+N%E1%BB%99i/@21.0313092,105.8413304,15z/data=!4m10!1m2!2m1!1zQsawdSDEkWnhu4duIGjDoCBu4buZaQ!3m6!1s0x3135abeb216908dd:0x92e0cd6062696342!8m2!3d21.0266056!4d105.8538003!15sChZCxrB1IMSRaeG7h24gaMOgIG7hu5lpkgELcG9zdF9vZmZpY2XgAQA!16s%2Fg%2F11cmgpnlnz?entry=ttu");
                } else if (header.getText().toString().equals("Sự kiện đọc sách")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Nh%C3%A0+S%C3%A1ch+L%C3%A2m/@21.0254922,105.8517835,17z/data=!4m10!1m2!2m1!1zUGjhu5Egc8OhY2ggxJBpbmggTOG7hSAtIE5ndXnhu4VuIFjDrQ!3m6!1s0x3135abeb6c9c0cd9:0x79b774635257e7fd!8m2!3d21.0256162!4d105.8543893!15sCiVQaOG7kSBzw6FjaCDEkGluaCBM4buFIC0gTmd1eeG7hW4gWMOtWiUiI3Bo4buRIHPDoWNoIMSRaW5oIGzhu4Ugbmd1eeG7hW4geMOtkgEKYm9va19zdG9yZZoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VRd2NuSkRjR3QzUlJBQuABAA!16s%2Fg%2F12vsqcny4?entry=ttu");
                } else if (header.getText().toString().equals("Hát dân gian và chèo")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/%C4%90%E1%BB%81n+B%C3%A0+Ki%E1%BB%87u/@21.0311203,105.8509303,17z/data=!4m6!3m5!1s0x3135abc0109a1963:0x467752b7dec78dad!8m2!3d21.0311153!4d105.8535052!16s%2Fg%2F1ym_l8159?entry=ttu");
                } else if (header.getText().toString().equals("Biểu diễn ca nhạc, rối")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Nh%C3%A0+H%C3%A1t+M%C3%BAa+R%E1%BB%91i+Th%C4%83ng+Long/@21.0316875,105.8484757,17z/data=!3m1!4b1!4m6!3m5!1s0x3135abc013454289:0x4e5ea7a5d23aad1c!8m2!3d21.0316826!4d105.8533466!16s%2Fg%2F1tdp2j4q?entry=ttu");
                } else if (header.getText().toString().equals("Nghệ thuật truyền thống")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Trung+T%C3%A2m+%C4%90%E1%BB%93ng+H%E1%BB%93+Th%E1%BB%A5y+S%E1%BB%B9/@21.0317122,105.8407509,15z/data=!4m10!1m2!2m1!1zxJDhu5NuZyBo4buTIEhvYSBUaOG7pXkgU8Sp!3m6!1s0x3135ab93589767ab:0x77888d48d483b6c7!8m2!3d21.0243865!4d105.8516242!15sChvEkOG7k25nIGjhu5MgSG9hIFRo4buleSBTxKlaHSIbxJHhu5NuZyBo4buTIGhvYSB0aOG7pXkgc8SpkgELd2F0Y2hfc3RvcmXgAQA!16s%2Fg%2F1v42c80j?entry=ttu");
                } else if (header.getText().toString().equals("Nghệ thuật kiểu mới")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Trung+t%C3%A2m+v%C4%83n+h%C3%B3a+qu%E1%BA%ADn+Ho%C3%A0n+Ki%E1%BA%BFm/@21.03726,105.8422574,17z/data=!4m6!3m5!1s0x3135abb9512d7945:0xa3c61fd782e05296!8m2!3d21.03726!4d105.847021!16s%2Fg%2F11c1rfmc4w?entry=ttu");
                } else if (header.getText().toString().equals("Âm nhạc truyền thống")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Qu%E1%BA%A3ng+tr%C6%B0%E1%BB%9Dng+%C4%90%C3%B4ng+Kinh+Ngh%C4%A9a+Th%E1%BB%A5c/@21.0319203,105.8465827,17z/data=!3m1!4b1!4m6!3m5!1s0x3135abbfecb5fe67:0xdf1bf52318546d6c!8m2!3d21.0319154!4d105.8514536!16s%2Fg%2F120tb77g?entry=ttu");
                }
                startActivity(intent);
            }
        });

        if (buttonText != null) {
            switch (buttonText) {
                case "Event 1":
                    header.setText("Cờ Hồ Gươm");
                    imageView.setImageResource(R.drawable.event_1);
                    eventTittle.setText("Sinh hoạt CLB cờ Hồ Gươm");
                    startDate.setText("22/10/2023");
                    endDate.setText("27/10/2023");
                    place.setText("Trung tâm thông tin văn hóa Hồ Gươm");
                    textDecription.setText("   Hoạt động giao lưu chơi cờ, cung cấp nơi vui chơi cho " +
                            "các bạn học sinh những ngày cuối tuần.");
                    break;
                case "Event 2":
                    header.setText("Biểu diễn vở diễn ngắn");
                    imageView.setImageResource(R.drawable.event_2);
                    eventTittle.setText("Biểu diễn các trích đoạn vở diễn, kịch ngắn");
                    startDate.setText("21/10/2023");
                    endDate.setText("22/10/2023");
                    place.setText("Khu vực trước cửa Rạp Công nhân - 42 phố Tràng Tiền");
                    textDecription.setText("   Biểu diễn những trích đoạn bất hủ, qua đó giúp giữ " +
                            "gìn những nét đẹp của phố đi bộ.");
                    break;
                case "Event 3":
                    header.setText("Trò chơi dân gian");
                    imageView.setImageResource(R.drawable.event_3);
                    eventTittle.setText("Trò chơi dân gian");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Ngã 3 Đinh Tiên Hoàng - Hàng Dầu (trước cửa Sở VH&TT)");
                    textDecription.setText("   Tổ chức các hoạt động trò chơi dân gian, phù hợp mọi " +
                            "lứa tuổi. Phụ huynh có thể cho các em tới chơi vào dịp lễ, cuối tuần.");
                    break;
                case "Event 4":
                    header.setText("Trò chơi thông minh");
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
                    header.setText("Sự kiện đọc sách");
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
                    header.setText("Hát dân gian và chèo");
                    imageView.setImageResource(R.drawable.event_6);
                    eventTittle.setText("Hát dân gian, chèo");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Sân khấu mặt trước đền Bà Kiệu");
                    textDecription.setText("   Hoạt động thường xuyên của sân khấu, đem lại cho " +
                            "khán thính giả cảm nhận về âm nhạc quê hương.");
                    break;
                case "Event 7":
                    header.setText("Biểu diễn ca nhạc, rối");
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
                    header.setText("Nghệ thuật truyền thống");
                    imageView.setImageResource(R.drawable.event_8);
                    eventTittle.setText("Chương trình nghệ thuật truyền thống");
                    startDate.setText("11/10/2023");
                    endDate.setText("11/12/2023");
                    place.setText("Khu vực đồng hồ Hoa Thụy Sĩ");
                    textDecription.setText("   Sự kiện thường trực, mang đến cho người xem vẻ đẹp " +
                            "nghệ thuật truyền thống quen thuộc mà sâu lắng!");
                    break;
                case "Event 9":
                    header.setText("Nghệ thuật kiểu mới");
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
                    header.setText("Âm nhạc truyền thống");
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