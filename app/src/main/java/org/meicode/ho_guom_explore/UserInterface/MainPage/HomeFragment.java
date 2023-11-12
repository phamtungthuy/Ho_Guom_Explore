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
import org.meicode.ho_guom_explore.UserInterface.CuisineAndAccommodationPage.CuisineAndAccommodation;
import org.meicode.ho_guom_explore.UserInterface.EventPage.EventActivity;
import org.meicode.ho_guom_explore.UserInterface.IntroductionPage.DetailActivity;
import org.meicode.ho_guom_explore.UserInterface.ServicePage.ServiceActivity;
import org.meicode.ho_guom_explore.UserInterface.SubPages.CommentActivity;
import org.meicode.ho_guom_explore.UserInterface.VisitPage.VisitActivity;

public class HomeFragment extends Fragment {
    Activity context;
    ImageButton commentButton;
    ImageButton eventButton;
    ImageButton serviceButton;
    ImageButton cuisineAndAccommodationButton;
    ImageButton introductionButton;
    ImageButton visitButton;
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
        eventButton = (ImageButton) context.findViewById(R.id.btnEvent);
        serviceButton = (ImageButton) context.findViewById(R.id.btnService);
        introductionButton = (ImageButton) context.findViewById(R.id.btnIntroduction);
        visitButton = (ImageButton) context.findViewById(R.id.btnVisit);
        cuisineAndAccommodationButton = (ImageButton) context.findViewById(R.id.btnCuisineAndAccommodation);        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                startActivity(intent);
            }
        });

        eventButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventActivity.class);
                startActivity(intent);
            }
        });

        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceActivity.class);
                startActivity(intent);
            }
        });

        cuisineAndAccommodationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CuisineAndAccommodation.class);
                startActivity(intent);
            }
        });

        introductionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                startActivity(intent);
            }
        });

        visitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VisitActivity.class);
                startActivity(intent);
            }
        });
    }
}