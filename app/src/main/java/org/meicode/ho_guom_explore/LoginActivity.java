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

public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button loginBtn;
    ImageButton rgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        loginBtn = findViewById(R.id.buttonLogin);
        rgBtn = findViewById(R.id.buttonRegister);

        handleShowPassword();

        loginBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        }));

        rgBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        }));
    }

    public void handleShowPassword() {
        final boolean[] isPasswordVisible = {false};

        EditText editTextLoginPassword = findViewById(R.id.editTextLoginPassword);

        // Thiết lập sự kiện click cho drawableRight
        editTextLoginPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (editTextLoginPassword.getRight() -
                            editTextLoginPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width()) - editTextLoginPassword.getPaddingRight()) {
                        // Người dùng đã nhấn vào drawableRight
                        if (isPasswordVisible[0]) {
                            // Đã hiển thị mật khẩu, chuyển thành ẩn mật khẩu
                            editTextLoginPassword.setInputType(InputType.TYPE_CLASS_TEXT |
                                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_security_24, 0,
                                    R.drawable.ic_eye, 0);
                        } else {
                            // Đã ẩn mật khẩu, chuyển thành hiển thị mật khẩu
                            editTextLoginPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                            editTextLoginPassword.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_security_24, 0,
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