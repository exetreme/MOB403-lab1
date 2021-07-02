package com.example.demo_androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class bai3_asyncTask extends AsyncTask<String,Void, Bitmap> {

    Listener mListener; //su dung interface
    ProgressDialog progressDialog; //su dung tien trinh.
    public bai3_asyncTask(Listener listener, Context context){
        this.mListener =listener;
        this.progressDialog = new ProgressDialog(context);

    }
    // chuan bi thuc hien
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Download image....");
        progressDialog.show();
    }

    //Tiến trình xử lý load hình từ server trong hàm doInBackground.
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;
        Bitmap bitmap= null;
        try{
            url =  new URL(strings[0]);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    //sau khi thuc hien
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if (bitmap !=null){
            mListener.onImageDownload(bitmap);
        }else {
            mListener.onError();
        }
    }
}
