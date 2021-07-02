package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bai1(View view) {
        Intent bai1 = new Intent(MainActivity.this, bai1_Lab1.class);
        startActivity(bai1);
    }

    public void bai2(View view) {
        Intent bai2= new Intent(MainActivity.this,bai2_lab1.class);
        startActivity(bai2);
    }

    public void bai3(View view) {
        Intent bai3 = new Intent(MainActivity.this,bai3_lab1.class);
        startActivity(bai3);
    }

    public void bai4(View view) {
        Intent bai4= new Intent(MainActivity.this, bai4_lab1.class);
        startActivity(bai4);
    }
}