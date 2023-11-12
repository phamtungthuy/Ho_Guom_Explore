package org.meicode.ho_guom_explore.UserInterface.SubPages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.meicode.ho_guom_explore.R;

public class CommentActivity extends AppCompatActivity {
    ImageButton backToHomePage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        backToHomePage = findViewById(R.id.commentToHomePage);
        backToHomePage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Fragment fragment = new Fragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.firstContainer, fragment).commit();
            }
        });
    }
}
