package com.example.colcom;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class navigation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setOnNavigationItemSelectedListener(navView);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navView = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.navigation_home:
                    startActivity(new Intent(navigation.this,searchbar.class));
                    //Toast.makeText(navigation.this,"hello",Toast.LENGTH_LONG);
                    break;
                case R.id.navigation_dashboard:
                     startActivity(new Intent(navigation.this,mail.class));
                    break;
                case R.id.navigation_notifications:
                    startActivity(new Intent(navigation.this,library.class));


                    break;
                case R.id.info:
                    startActivity(new Intent(navigation.this,about.class));
                    break;
                case R.id.logout:
                    AlertDialog.Builder builder=new AlertDialog.Builder(navigation.this);
                    builder.setTitle("Do you want to logout?") ;
                    builder.setMessage("Are you sure?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(navigation.this,MainActivity.class);
                            startActivity(intent);

                            SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                            SharedPreferences.Editor editor=preferences.edit();
                            editor.putString("remember","false");
                            editor.apply();
                            finish();
                        }
                    });
                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"No button clicked",Toast.LENGTH_SHORT);
                        }
                    });
                    AlertDialog dialog=builder.create();
                    dialog.show();
                    break;


            }
            return true;
        }
    };
}
