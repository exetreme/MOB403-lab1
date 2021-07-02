package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class bai3_lab1 extends AppCompatActivity implements View.OnClickListener,Listener {
     TextView tvMessage;
     Button btnLoad;
     ImageView imgLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab1);

        tvMessage = findViewById(R.id.tvMessage);
        btnLoad = findViewById(R.id.btn_Load);
        imgLoad = findViewById(R.id.imgLoad);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      new bai3_asyncTask(this,this).execute("https://thosuaxe.info/wp-content/uploads/2021/03/M%E1%BB%99t-trong-nh%E1%BB%AFng-Memes-kinh-%C4%91i%E1%BB%83n-nh%E1%BA%A5t-tr%C3%AAn-internet.jpg");
    }

    @Override
    public void onImageDownload(Bitmap bitmap) {
        imgLoad.setImageBitmap(bitmap);
        tvMessage.setText("Image Downloaded");

    }

    @Override
    public void onError() {
        tvMessage.setText("Error download image");
    }
}