package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bai4_lab1 extends AppCompatActivity implements View.OnClickListener  {
     EditText edtTime4;
     Button btnRun4;
     TextView tvResult4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab1);
        edtTime4 = findViewById(R.id.txtTime);
        btnRun4 = findViewById(R.id.btnRunAsync);
        tvResult4 = findViewById(R.id.tvResult);
        btnRun4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String sleepTime = edtTime4.getText().toString();
    new bai4_asynTask(this,tvResult4,edtTime4).execute(sleepTime);
    }
}