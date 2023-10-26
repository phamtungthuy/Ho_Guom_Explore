package org.meicode.ho_guom_explore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button loginBtn;
    ImageButton rgBtn;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    TextView textView;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        loginBtn = findViewById(R.id.buttonLogin);
        rgBtn = findViewById(R.id.buttonRegister);
        textView = findViewById(R.id.registerNow);
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.registerNow);
        textView.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        }));


        handleShowPassword();

        loginBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                progressBar.setVisibility(View.VISIBLE);
                String username, password;
                username = String.valueOf(edUsername.getText());
                password = String.valueOf(edPassword.getText());

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Login successful",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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