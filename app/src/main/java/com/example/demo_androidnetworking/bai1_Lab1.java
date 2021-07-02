package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.net.URL;

public class bai1_Lab1 extends AppCompatActivity implements View.OnClickListener {
    private Button btn_load;
    private TextView tv_result_bai1;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_lab1);

        btn_load = findViewById(R.id.btnLoad_bai1);
        tv_result_bai1 = findViewById(R.id.textView_bai1);
        img = findViewById(R.id.imageView_bai1);

        btn_load.setOnClickListener(this);
    }

    //using Thread
    @Override
    public void onClick(View v) {
     final Thread thread = new Thread(new Runnable() {
         @Override
         public void run() {
            final Bitmap bitmap   = loadImage("https://ichef.bbci.co.uk/news/976/cpsprodpb/F1F2/production/_118283916_b19c5a1f-162b-410b-8169-f58f0d153752.jpg");
            img.post(new Runnable() {
                @Override
                public void run() {
                tv_result_bai1.setText("Successfully!!!");
                img.setImageBitmap(bitmap);
                }
            });
         }
     });
     thread.start();
    }
    //load Image on the Internet
    private Bitmap loadImage(String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url= new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        return bitmap;
    }
}