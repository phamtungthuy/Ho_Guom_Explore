package org.meicode.ho_guom_explore.UserInterface.ServicePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetail;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceDetailMapActivity;

public class ServiceDetail extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);
        ImageButton dtBackBtn = findViewById(R.id.back);
        ImageButton mapButton = findViewById(R.id.vs_map_btn);


        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDetail.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("buttonText");
        TextView header = findViewById(R.id.title);

        ImageView imageView = findViewById(R.id.img);
        TextView serviceTittle = findViewById(R.id.serviceTittle);
        TextView place = findViewById(R.id.place);
        TextView phone = findViewById(R.id.phone);
        TextView textDecription = findViewById(R.id.textDecription);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDetail.this, ServiceDetailMapActivity.class);
                if (header.getText().toString().equals("Thuê xe điện 14 chỗ")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/H%E1%BB%93+Ho%C3%A0n+Ki%E1%BA%BFm/@21.0287797,105.8497898,17z/data=!4m6!3m5!1s0x3135ab953357c995:0x1babf6bb4f9a20e!8m2!3d21.0286669!4d105.8521484!16zL20vMGdwNjV3?entry=ttu");
                } else if (header.getText().toString().equals("Thuê xe điện trẻ em")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/P.+%C4%90inh+Ti%C3%AAn+Ho%C3%A0ng,+Vi%E1%BB%87t+Nam/@20.072317,106.2357665,17z/data=!4m6!3m5!1s0x3135abeaaa8ff92d:0xd438536f21a1cf9e!8m2!3d20.072312!4d106.2383414!16s%2Fg%2F120vhgw3?entry=ttu");
                } else if (header.getText().toString().equals("Bán tặng đồ lưu niệm")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/P.+L%C3%AA+Th%C3%A1i+T%E1%BB%95,+Ho%C3%A0n+Ki%E1%BA%BFm,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@21.0289149,105.8487967,17z/data=!3m1!4b1!4m6!3m5!1s0x3135abbfe761ce93:0x78f2595e220677f9!8m2!3d21.0289099!4d105.8513716!16s%2Fg%2F1tf5ys47?entry=ttu");
                } else if (header.getText().toString().equals("Trông giữ xe")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/Tr%C3%A0ng+Ti%E1%BB%81n,+Ho%C3%A0n+Ki%E1%BA%BFm,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@21.0252756,105.8450692,16z/data=!3m1!4b1!4m10!1m2!2m1!1zTmfDoyB0xrAgVHLDoG5nIFRp4buBbg!3m6!1s0x3135abeb7040ac25:0x163d0b0f9cc7edab!8m2!3d21.0251629!4d105.8547173!15sChZOZ8OjIHTGsCBUcsOgbmcgVGnhu4FukgEMc3VibG9jYWxpdHkx4AEA!16s%2Fg%2F1hb_gdz1p?entry=ttu");
                } else if (header.getText().toString().equals("Mua sắm lễ vật")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/%C4%90%E1%BB%81n+Quan+%C4%90%E1%BA%BF+(%C4%90%E1%BB%81n+Th%E1%BB%9D+Quan+V%C5%A9)/@21.0360469,105.8494855,17z/data=!4m6!3m5!1s0x3135ab894258db3b:0x6762a65565c45fe9!8m2!3d21.0360419!4d105.8520604!16s%2Fg%2F11grc0_b5d?entry=ttu");
                } else if (header.getText().toString().equals("Biểu diễn ca nhạc")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/%C4%90%E1%BB%81n+B%E1%BA%A1ch+M%C3%A3/@21.0357875,105.8461375,17z/data=!3m1!4b1!4m6!3m5!1s0x3135abbf47ca8df5:0xe66fe1153b046b!8m2!3d21.0357826!4d105.8510084!16s%2Fg%2F120w8hg8?entry=ttu");
                } else if (header.getText().toString().equals("Du lịch đền Ngọc Sơn")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/%C4%90%E1%BB%81n+Ng%E1%BB%8Dc+S%C6%A1n/@21.030698,105.8498061,17z/data=!3m1!4b1!4m6!3m5!1s0x3135abc000809ea7:0xbb2716ec0282371d!8m2!3d21.030693!4d105.852381!16s%2Fm%2F0gtxhmt?entry=ttu");
                } else if (header.getText().toString().equals("Chụp ảnh đường phố")) {
                    intent.putExtra("mapUrl", "https://www.google.com/maps/place/H%E1%BB%93+G%C6%B0%C6%A1m+(Hoa%CC%80n+Ki%C3%AA%CC%81m)/@21.030708,105.8498061,17z/data=!4m10!1m2!2m1!1zcGjhu5EgxJFpIGLhu5kgaOG7kyBnxrDGoW0!3m6!1s0x3135ac69f861af3f:0x331250d72cd2fa28!8m2!3d21.0284743!4d105.8525795!15sChpwaOG7kSDEkWkgYuG7mSBo4buTIGfGsMahbVocIhpwaOG7kSDEkWkgYuG7mSBo4buTIGfGsMahbZIBEnRvdXJpc3RfYXR0cmFjdGlvbpoBI0NoWkRTVWhOTUc5blMwVkpRMEZuU1VSTlgzUjFhRTFSRUFF4AEA!16s%2Fg%2F1td7ksg7?entry=ttu");
                }
                startActivity(intent);
            }
        });


        if (buttonText != null) {
            switch (buttonText) {
                case "Service 1":
                    header.setText("Thuê xe điện 14 chỗ");
                    imageView.setImageResource(R.drawable.service_1);
                    serviceTittle.setText("Dịch vụ thuê xe điện 14 chỗ");
                    place.setText("Khu vực không gian bên cạnh bờ hồ Hoàn Kiếm");
                    phone.setText("+84 986 776 494");
                    textDecription.setText("   Khu di tích có sẵn dịch vụ vận chuyển bằng xe điện " +
                            "ngay tại bờ hồ. Đội ngũ lái xe được đào tạo chuyên nghiệp, phong cách " +
                            "phục vụ tận tình rất sẵn lòng được phục vụ quý khách. Ngoài ra quý khách " +
                            "có thể lựa chọn thuê xe tự lái nếu cung cấp đầy đủ giấy tờ.");
                    break;
                case "Service 2":
                    header.setText("Thuê xe điện trẻ em");
                    imageView.setImageResource(R.drawable.service_2);
                    serviceTittle.setText("Dịch vụ thuê xe điện cho trẻ em");
                    place.setText("Khu vực không gian sát vỉa hè phố Đinh Tiên Hoàng");
                    phone.setText("+84 335 336 777");
                    textDecription.setText("   Cho phép thuê xe điện trẻ em một chỗ ngồi. Vì phương tiện " +
                            "dành cho trẻ em, nghiêm cấm hành vi sử dụng xe thuê cho người lớn, cụ thể " +
                            "là người trên 18 tuổi. Rất mong quý khách chấp hành nội dung quy định.");
                    break;
                case "Service 3":
                    header.setText("Bán tặng đồ lưu niệm");
                    imageView.setImageResource(R.drawable.service_3);
                    serviceTittle.setText("Dịch vụ bán, tặng quà lưu niệm");
                    place.setText("Cửa hàng lưu niệm phố Lê Thái Tổ");
                    phone.setText("+84 959 363 989");
                    textDecription.setText("   Nếu quý khách muốn có một món quà lưu niệm tặng cho gia đình " +
                            "hoặc bạn bè sau chuyến du lịch hồ Gươm, chúng tôi cung cấp dịch vụ tặng quà lưu " +
                            "niệm tận nơi. Vui lòng sử dụng số điện thoại đã được cung cấp bên trên để " +
                            "liên hệ tới cửa hàng. Cảm ơn quý khách đã ủng hộ!");
                    break;
                case "Service 4":
                    header.setText("Trông giữ xe");
                    imageView.setImageResource(R.drawable.service_4);
                    serviceTittle.setText("Dịch vụ trông giữ xe ngày đêm");
                    place.setText("Khu vực không gian ngã tư Tràng Tiền");
                    phone.setText("+84 666 633 262");
                    textDecription.setText("   Chúng tôi cung cấp chỗ để xe khi bạn đem phương tiện tới " +
                            "hồ Hoàn Kiếm. Bạn có thể lựa chọn trông giữ xe ban ngày, hay trông giữ xe " +
                            "qua đêm với giá cả phải chăng. Chúc các bạn có một ngày vui vẻ tại phố đi bộ.");
                    break;
                case "Service 5":
                    header.setText("Mua sắm lễ vật");
                    imageView.setImageResource(R.drawable.service_5);
                    serviceTittle.setText("Dịch vụ mua sắm lễ vật, làm Lễ dâng hương");
                    place.setText("Đền Quan Đế 28 Hàng Buồm");
                    phone.setText("+84 266 373 139");
                    textDecription.setText("   Cửa hàng chúng tôi cam kết cung cấp mặt hàng tốt nhất tới " +
                            "các bạn. Dịch vụ dâng hương, tạ lễ mở cửa mọi dịp trong năm. Nếu có nhu cầu " +
                            "bạn hãy liên hệ với chúng tôi qua số điện thoại để nhận được lời khuyên " +
                            "hữu ích.");
                    break;
                case "Service 6":
                    header.setText("Biểu diễn ca nhạc");
                    imageView.setImageResource(R.drawable.service_6);
                    serviceTittle.setText("Dịch vụ biểu diễn, ca hát theo yêu cầu");
                    place.setText("Đền Bạch Mã 76 Hàng Buồm");
                    phone.setText("+84 385 989 800");
                    textDecription.setText("   Nhận biểu diễn theo nhu cầu cho các sự kiện xung quanh " +
                            "hồ Gươm. Liên hệ hostline 0 385 989 800 để đặt hàng.");
                    break;
                case "Service 7":
                    header.setText("Du lịch đền Ngọc Sơn");
                    imageView.setImageResource(R.drawable.service_7);
                    serviceTittle.setText("Dịch vụ tham quan du lịch đền Ngọc Sơn");
                    place.setText("Đền Ngọc Sơn phố Đinh Tiên Hoàng");
                    phone.setText("+84 676 335 337");
                    textDecription.setText("   Dịch vụ đặt hàng trước vé vào cửa đền Ngọc Sơn cho quý " +
                            "khách. Chúng tôi mở dịch vụ này để quý khách không phải chen lấn trong việc " +
                            "mua vé vào đền như trước. Vì là dịch vụ mới, chúng tôi rất mong có được " +
                            "sự ủng hộ từ quý khách tham quan.");
                    break;
                case "Service 8":
                    header.setText("Chụp ảnh đường phố");
                    imageView.setImageResource(R.drawable.service_8);
                    serviceTittle.setText("Dịch vụ chụp ảnh đường phố");
                    place.setText("Phồ đi bộ hồ Hoàn Kiếm");
                    phone.setText("+84 275 686 772");
                    textDecription.setText("   Nhận chụp ảnh chân dung, ảnh áo dài (có đi kèm dịch vụ " +
                            "cho thuê áo dài giá cả phải chăng). In ảnh kỹ thuật số và chỉnh sửa ảnh " +
                            "theo yêu cầu của quý khách. Nhận hàng ngay trong một buổi!");
                    break;
                default:
                    break;
            }
        }
    }
}
