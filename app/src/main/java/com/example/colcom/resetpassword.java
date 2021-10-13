package com.example.colcom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {
    private EditText emailedittext;
    private Button btn1;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        emailedittext=(EditText) findViewById(R.id.ev);
        btn1=(Button) findViewById(R.id.rp);
        auth=FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpass();
            }
        });

    }
    private void resetpass(){
        String email=emailedittext.getText().toString().trim();
        if(email.isEmpty()){
            emailedittext.setError("email is required");
            emailedittext.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailedittext.setError("please provide valid mail");
            emailedittext.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(resetpassword.this,"check your mail to reset your password",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(resetpassword.this,"try again! something happend wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}