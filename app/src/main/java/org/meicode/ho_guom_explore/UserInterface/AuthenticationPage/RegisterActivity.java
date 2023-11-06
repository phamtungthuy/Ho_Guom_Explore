package org.meicode.ho_guom_explore.UserInterface.AuthenticationPage;

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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.MainActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername, edPassword, edConfirmPassword;
    Button registerBtn;
    ImageButton lgBtn;
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
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        edUsername = findViewById(R.id.editTextRegUsername);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        registerBtn = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.loginNow);

        textView.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }));

        registerBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String username, password, email;
                username = String.valueOf(edUsername.getText());
                password = String.valueOf(edPassword.getText());
                email = username;

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(RegisterActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Account created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

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