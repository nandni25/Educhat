package com.example.colcom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.firebase.database.collection.LLRBNode;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class recaptcha extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {
    CheckBox check;
    GoogleApiClient googleApiClient;
    String Sitekey="6LdONZkaAAAAAMBSweXAj_7svZ9ScKQWfbGBjdue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recaptcha);
      check=findViewById(R.id.cap);
        googleApiClient=new GoogleApiClient.Builder(this)
                .addApi(SafetyNet.API)
                .addConnectionCallbacks(recaptcha.this)
                .build();
        googleApiClient.connect();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check.isChecked()){
                    SafetyNet.SafetyNetApi.verifyWithRecaptcha(googleApiClient,Sitekey)
                            .setResultCallback(new ResultCallback<SafetyNetApi.RecaptchaTokenResult>() {
                                @Override
                                public void onResult(@NonNull SafetyNetApi.RecaptchaTokenResult recaptchaTokenResult) {
                                    Status status=recaptchaTokenResult.getStatus();
                                    if((status!=null && status.isSuccess())){
                                        Toast.makeText(getApplicationContext(),"Successfully Verified!!",Toast.LENGTH_SHORT).show();
                                        check.setTextColor(Color.GREEN);
                                        //startActivity(new Intent(recaptcha.this,MainActivity.class));
                                    }
                                }
                            });
                }else{
                    check.setTextColor(Color.BLACK);
                }
            }
        });
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}