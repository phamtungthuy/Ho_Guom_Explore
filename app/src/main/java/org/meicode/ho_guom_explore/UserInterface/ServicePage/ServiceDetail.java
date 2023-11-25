package org.meicode.ho_guom_explore.UserInterface.ServicePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.meicode.ho_guom_explore.R;

public class ServiceDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);
        ImageButton dtBackBtn = findViewById(R.id.back);

        dtBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceDetail.this, ServiceActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String buttonText = intent.getStringExtra("buttonText");

        ImageView imageView = findViewById(R.id.img);
        TextView serviceTittle = findViewById(R.id.serviceTittle);
        TextView place = findViewById(R.id.place);
        TextView phone = findViewById(R.id.phone);
        TextView textDecription = findViewById(R.id.textDecription);


        if (buttonText != null) {
            switch (buttonText) {
                case "Service 1":
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
                    imageView.setImageResource(R.drawable.service_2);
                    serviceTittle.setText("Dịch vụ thuê xe điện cho trẻ em");
                    place.setText("Khu vực không gian sát vỉa hè phố Đinh Tiên Hoàng");
                    phone.setText("+84 335 336 777");
                    textDecription.setText("   Cho phép thuê xe điện trẻ em một chỗ ngồi. Vì phương tiện " +
                            "dành cho trẻ em, nghiêm cấm hành vi sử dụng xe thuê cho người lớn, cụ thể " +
                            "là người trên 18 tuổi. Rất mong quý khách chấp hành nội dung quy định.");
                    break;
                case "Service 3":
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
                    imageView.setImageResource(R.drawable.service_4);
                    serviceTittle.setText("Dịch vụ trông giữ xe ngày đêm");
                    place.setText("Khu vực không gian ngã tư Tràng Tiền");
                    phone.setText("+84 666 633 262");
                    textDecription.setText("   Chúng tôi cung cấp chỗ để xe khi bạn đem phương tiện tới " +
                            "hồ Hoàn Kiếm. Bạn có thể lựa chọn trông giữ xe ban ngày, hay trông giữ xe " +
                            "qua đêm với giá cả phải chăng. Chúc các bạn có một ngày vui vẻ tại phố đi bộ.");
                    break;
                case "Service 5":
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
                    imageView.setImageResource(R.drawable.service_6);
                    serviceTittle.setText("Dịch vụ biểu diễn, ca hát theo yêu cầu");
                    place.setText("Đền Bạch Mã 76 Hàng Buồm");
                    phone.setText("+84 385 989 800");
                    textDecription.setText("   Nhận biểu diễn theo nhu cầu cho các sự kiện xung quanh " +
                            "hồ Gươm. Liên hệ hostline 0 385 989 800 để đặt hàng.");
                    break;
                case "Service 7":
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
