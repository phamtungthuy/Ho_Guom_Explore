package org.meicode.ho_guom_explore.UserInterface.SubPages;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.meicode.ho_guom_explore.R;
import org.meicode.ho_guom_explore.UserInterface.MainPage.HomePageActivity;
import org.meicode.ho_guom_explore.UserInterface.VisitPage.VisitActivity;

import java.util.HashMap;

public class CommentActivity extends AppCompatActivity {
    ImageButton backToHomePage;

    String myUid, myEmail;
    EditText editComment;
    Button sendComment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        backToHomePage = findViewById(R.id.commentToHomePage);

        editComment = findViewById(R.id.commentBox);
        sendComment = findViewById(R.id.buttonSendComment);
        backToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
        checkUserStatus();

        sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
            }
        });
    }

    private void postComment() {
        String comment = editComment.getText().toString().trim();
        String userName = getUserName(myEmail);

        //validate the comment
        if(TextUtils.isEmpty(comment)){
            //no value is entered
            Toast.makeText(this, "Please enter Comment", Toast.LENGTH_SHORT).show();
            return;
        }

        String timeStamp = String.valueOf(System.currentTimeMillis());
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Comment").child(userName);

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("cID", timeStamp);
        hashMap.put("comment", comment);
        hashMap.put("timeStamp", timeStamp);
        hashMap.put("uid", myUid);
        hashMap.put("uEmail", myEmail);

        reference.child(timeStamp).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(CommentActivity.this, "Comment added", Toast.LENGTH_SHORT).show();
                editComment.setText("");
            }
        }).addOnFailureListener(new OnFailureListener(){

                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CommentActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private String getUserName(String myEmail) {
        int index = myEmail.indexOf("@");
        if (index != -1) {
            return myEmail.substring(0, index);
        }
        return "";
    }

    private void checkUserStatus(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            myEmail = user.getEmail();
            myUid = user.getUid();
        }
    }
}
