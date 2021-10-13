package com.example.colcom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class mail extends AppCompatActivity {
EditText etTo,etSubject,etMessage;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        etTo=findViewById(R.id.et_to);
        etSubject=findViewById(R.id.et_subject);
        etMessage=findViewById(R.id.et_msg);
        btn=findViewById(R.id.bt_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmail();
            }
        });

    }

    private void sendmail() {
        String recipients=etTo.getText().toString();
        String[] rec=recipients.split(",");
        String subject=etSubject.getText().toString();
        String message=etMessage.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,rec);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose an email client"));
    }
}