package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.SubPages.CommentActivity;

public class HomeFragment extends Fragment {
    Activity context;
    ImageButton commentButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    public void onStart() {
        super.onStart();
        commentButton = (ImageButton) context.findViewById(R.id.btnComment);
        commentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                startActivity(intent);
            }
        });
    }
}