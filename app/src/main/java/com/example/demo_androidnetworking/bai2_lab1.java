package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class bai2_lab1 extends AppCompatActivity  {
    public static int Time_Out =  2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab1);
        setTitle("Man hinh chao !!!");
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(bai2_lab1.this,bai2_screen2_lab1.class);
            startActivity(intent);
            finish();
        },
                Time_Out);
    }
}