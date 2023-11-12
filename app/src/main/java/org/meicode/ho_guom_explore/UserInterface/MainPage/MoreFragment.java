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

import com.google.firebase.auth.FirebaseAuth;

import org.meicode.ho_guom_explore.ManageInterface.UploadCuisineAndAccommodation;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.AuthenticationPage.LoginActivity;
import org.meicode.ho_guom_explore.UserInterface.SubPages.CommentActivity;

public class MoreFragment extends Fragment {
    Activity context;

    Button signOutButton, uploadButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    public void onStart() {
        super.onStart();
        signOutButton = (Button) context.findViewById(R.id.sign_out);
        uploadButton = context.findViewById(R.id.uploadButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UploadCuisineAndAccommodation.class);
                startActivity(intent);
            }
        });
    }
}