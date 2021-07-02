package com.example.demo_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class bai2_screen2_lab1 extends AppCompatActivity implements View.OnClickListener{
        private ImageView imageView;
        private Button btn_Load;
        private String url = "https://thosuaxe.info/wp-content/uploads/2021/03/Meme-l%C3%A0-g%C3%AC.jpg";
        private Bitmap bitmap = null;
        private TextView tvMessage;
        private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_screen2_lab1);
        setTitle("Man hinh chinh");
        imageView  = findViewById(R.id.img_bai2_screen2_lab1);
        btn_Load = findViewById(R.id.btl_Load_bai2_screen2_lab1);
        tvMessage = findViewById(R.id.tv_message_bai2_screen2);

       btn_Load.setOnClickListener( this);
    }
   private Handler messageHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
           Bundle bundle  = msg.getData();
           String message= bundle.getString("message");
           tvMessage.setText(message);
           imageView.setImageBitmap(bitmap);
           progressDialog.dismiss();
        }
   };
    @Override
    public void onClick(View v) {
       progressDialog = ProgressDialog.show(bai2_screen2_lab1.this,"","Downloading...");
       Runnable aRunnable = new Runnable() {
           @Override
           public void run() {
               bitmap= downLoadBitMap(url);
               Message msg = messageHandler.obtainMessage();
               Bundle bundle = new Bundle();
               String threadMessage = "thanh cong";
               bundle.putString("message",threadMessage);
               msg.setData(bundle);
               messageHandler.sendMessage(msg);
           }
       };
       Thread aThread = new Thread(aRunnable);
       aThread.start();
    }

    private  Bitmap downLoadBitMap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}