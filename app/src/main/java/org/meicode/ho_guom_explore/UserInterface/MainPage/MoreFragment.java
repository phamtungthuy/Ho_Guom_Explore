package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import org.meicode.ho_guom_explore.ManageInterface.UploadCuisineAndAccommodation;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.AuthenticationPage.LoginActivity;

public class MoreFragment extends Fragment {
    Activity context;

    Button signOutButton, uploadButton, informationButton, shareButton;

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
        informationButton = context.findViewById(R.id.button_information);
        shareButton = context.findViewById(R.id.button_share);

        informationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareApp(context);
            }
        });
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

    private void openDialog() {
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getActivity().getSupportFragmentManager(), "HoGuomExplore");
    }

    private void ShareApp(Activity context){
        String appPackageName = this.context.getPackageName();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "HoGuomExplore is a good application" );
        sendIntent.setType("text/plain");
        this.context.startActivity(sendIntent);
    }
}