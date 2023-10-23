package org.meicode.ho_guom_explore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edConfirmPassword;
    Button registerBtn;
    ImageButton lgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        registerBtn = findViewById(R.id.buttonRegister);
//        rgBtn = findViewById(R.id.buttonRegister);

        registerBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        }));

        handleShowPassword(edPassword);
        handleShowPassword(edConfirmPassword);

    }

    public void handleShowPassword(EditText editText) {
        final boolean[] isPasswordVisible = {false};


        // Thiết lập sự kiện click cho drawableRight
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (editText.getRight() -
                            editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()) - editText.getPaddingRight()) {
                        // Người dùng đã nhấn vào drawableRight
                        if (isPasswordVisible[0]) {
                            // Đã hiển thị mật khẩu, chuyển thành ẩn mật khẩu
                            editText.setInputType(InputType.TYPE_CLASS_TEXT |
                                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_security_24, 0,
                                    R.drawable.ic_eye, 0);
                        } else {
                            // Đã ẩn mật khẩu, chuyển thành hiển thị mật khẩu
                            editText.setInputType(InputType.TYPE_CLASS_TEXT);
                            editText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_security_24, 0,
                                    R.drawable.ic_slash_eye, 0);
                        }
                        isPasswordVisible[0] = !isPasswordVisible[0];
                        return true;
                    }
                }
                return false;
            }
        });
    }
}