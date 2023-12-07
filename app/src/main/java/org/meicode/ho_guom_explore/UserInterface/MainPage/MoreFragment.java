package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.meicode.ho_guom_explore.ManageInterface.ManagementActivity;
import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.AuthenticationPage.LoginActivity;

public class MoreFragment extends Fragment {
    FirebaseAuth mAuth;
    FirebaseUser user;
    Activity context;

    Button signOutButton, uploadButton, informationButton, shareButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    private void checkUserRole() {
        FirebaseUser user = mAuth.getCurrentUser();
//        FirebaseDatabase.getInstance().getReference("users").child(user.getUid()).child("isAdmin")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.exists()) {
//                            String role = dataSnapshot.getValue(String.class);
//
//                            if (role.equals("1")) {
//                                // Hiển thị nút
//                                uploadButton.setVisibility(View.VISIBLE);
//                            } else {
//                                // Ẩn nút
//                                uploadButton.setVisibility(View.GONE);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        String role = FirebaseDatabase.getInstance().getReference("users").child(user.getUid()).child("role").toString();
        if (role.equals("admin")) {
            // Hiển thị nút
            uploadButton.setVisibility(View.VISIBLE);
        } else {
            // Ẩn nút
            uploadButton.setVisibility(View.GONE);
        }
    }

    public void onStart() {
        super.onStart();
        signOutButton = (Button) context.findViewById(R.id.sign_out);
        uploadButton = context.findViewById(R.id.uploadButton);
        informationButton = context.findViewById(R.id.button_information);
        shareButton = context.findViewById(R.id.button_share);

        user = mAuth.getCurrentUser();


        FirebaseDatabase.getInstance().getReference("UserInfo").child(user.getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String role = dataSnapshot.child("role").getValue(String.class);
                            if (role.equals("admin")) {
                                // Hiển thị nút
                                uploadButton.setVisibility(View.VISIBLE);
                            } else {
                                // Ẩn nút
                                uploadButton.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Xử lý lỗi
                    }
                });

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
                Intent intent = new Intent(context, ManagementActivity.class);
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