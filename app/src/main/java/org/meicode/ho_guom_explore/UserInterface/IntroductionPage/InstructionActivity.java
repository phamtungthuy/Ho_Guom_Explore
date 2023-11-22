package org.meicode.ho_guom_explore.UserInterface.IntroductionPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import org.meicode.ho_guom_explore.UserInterface.BaseActivity;

import org.meicode.ho_guom_explore.R;

public class InstructionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        handleNavigationBar(findViewById(R.id.bottomNavigationView));

        ImageButton insBackBtn = findViewById(R.id.ins_back_btn);

        insBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionActivity.this, DetailActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}