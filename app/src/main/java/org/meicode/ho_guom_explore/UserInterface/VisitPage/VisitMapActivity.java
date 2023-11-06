package org.meicode.ho_guom_explore.UserInterface.VisitPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.meicode.ho_guom_explore.R;

public class VisitMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitmap);

        ImageButton vsBackBtn = findViewById(R.id.vs_back_btn);

        vsBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisitMapActivity.this, VisitActivity.class);
                startActivity(intent);
                finish();
            }
        });

        WebView webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        String mapUrl = "https://www.google.com/maps/search/?api=1&query=Hồ+Gươm";
        webView.loadUrl(mapUrl);
    }
}
