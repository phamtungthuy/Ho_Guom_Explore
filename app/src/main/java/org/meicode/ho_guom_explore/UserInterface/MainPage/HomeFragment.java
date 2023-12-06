package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
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
    CardView introductionCard, visitCard, eventCard, serviceCard, cuisineAndAccommodationCard, commentCard;

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
        introductionCard = context.findViewById(R.id.introductionCard);
        visitCard = context.findViewById(R.id.visitCard);
        eventCard = context.findViewById(R.id.eventCard);
        serviceCard = context.findViewById(R.id.serviceCard);
        cuisineAndAccommodationCard = context.findViewById(R.id.cuisineAndAccommodationCard);
        commentCard = context.findViewById(R.id.commentCard);
        commentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentActivity.class);
                startActivity(intent);
            }
        });

        eventCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventActivity.class);
                startActivity(intent);
            }
        });

        serviceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ServiceActivity.class);
                startActivity(intent);
            }
        });

        cuisineAndAccommodationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CuisineAndAccommodation.class);
                startActivity(intent);
            }
        });

        introductionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                startActivity(intent);
            }
        });

        visitCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VisitActivity.class);
                startActivity(intent);
            }
        });
    }
}