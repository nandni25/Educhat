package com.example.colcom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Study1Activity2 extends AppCompatActivity {
    PDFView study1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study12);
        study1=(PDFView) findViewById(R.id.pdfView1);
        study1.fromAsset("kecs104.pdf").load();
    }
}