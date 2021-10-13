package com.example.colcom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Study4Activity2 extends AppCompatActivity {
    PDFView study4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study42);
        study4=(PDFView) findViewById(R.id.pdfView4);
        study4.fromAsset("DATABASE MANAGEMENT SYSTEMS.pdf").load();
    }
}