package com.example.colcom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class about extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setOnNavigationItemSelectedListener(navView);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navView = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.vtop:
                    startActivity(new Intent(about.this,vtop.class));
                    Toast.makeText(about.this,"hello",Toast.LENGTH_LONG);
                    break;
                case R.id.faculty:
                    startActivity(new Intent(about.this,faculty.class));
                    break;
                case R.id.fee:

                 startActivity(new Intent(about.this,fee.class));

                    break;
                case R.id.info:
                    startActivity(new Intent(about.this,webviewlib.class));
                    break;



            }
            return true;
        }
    };
}
