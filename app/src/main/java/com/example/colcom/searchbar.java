package com.example.colcom;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
public class searchbar extends AppCompatActivity {
    ListView listView;
    ArrayList<String>  num = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchbar);
        listView = findViewById(R.id.listView);
        etSearch = findViewById(R.id.etSearch);
        num.add("Pon Harshvardhan sir");
        num.add("Sharmasth vali sir");
        num.add("Rajeev sir");
        num.add("Ambalika ma'am ");
        num.add("Dr. R Rakesh ");
        num.add("Anant kant sir");


        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, num);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ActivityCompat.requestPermissions(searchbar.this,new String[]{Manifest.permission.CALL_PHONE},2);


                if (position == 0) {


                    String number="9840768153";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);




                }
                if(position==1){
                    String number="9444679387";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);
                }

                if (position == 2) {

                    String number="9840768026";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);


                }
                if (position == 3) {

                    String number="8106519344";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);


                }
                if (position == 4) {

                    String number="9840768026";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);


                }
                if (position == 5) {

                    String number="9340294513";
                    Intent i=new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse("tel:"+number));
                    startActivity(i);


                }



            }
        });


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
