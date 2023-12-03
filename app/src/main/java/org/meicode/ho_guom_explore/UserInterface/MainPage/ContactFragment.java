package org.meicode.ho_guom_explore.UserInterface.MainPage;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.meicode.ho_guom_explore.R;

public class ContactFragment extends Fragment {
    private static final int REQUEST_CALL = 1;
//    static int PERMISSION_CODE = 100;
    Activity context;
    TextView phoneNum1;
    TextView phoneNum2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        phoneNum1 = context.findViewById(R.id.phoneNum1);
        phoneNum2 = context.findViewById(R.id.phoneNum2);

        phoneNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String number = phoneNum1.getText().toString();
//                String dial = "tel:" + number;
//                Intent i = new Intent(Intent.ACTION_CALL);
//                i.setData(Uri.parse(dial));
//                startActivity(i);
                makePhoneCall();
            }
        });

        phoneNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
    }
    private void makePhoneCall() {
        String number = phoneNum1.getText().toString();
        if(ContextCompat.checkSelfPermission(context,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
        else{
            String dial = "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }
            else{
                Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}