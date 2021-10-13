package com.example.colcom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class enterencecode extends AppCompatActivity {
    private EditText code;
    private Button sub;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterencecode);
        code=(EditText)  findViewById(R.id.code);
        sub=(Button) findViewById(R.id.sub);
        auth= FirebaseAuth.getInstance();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(code.getText().toString().equals("123456")){
                    startActivity(new Intent(enterencecode.this,navigation.class));
                    Toast.makeText(enterencecode.this,"correct",Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(enterencecode.this,"invalid code",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}