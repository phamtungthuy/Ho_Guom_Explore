package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.meicode.ho_guom_explore.R;

public class MapFragment extends Fragment {
    WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        webView.setWebViewClient(new WebViewClient());
//        String mapUrl = "https://www.google.com/maps/search/?api=1&query=Hồ+Gươm";
//        webView.loadUrl(mapUrl);
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
}