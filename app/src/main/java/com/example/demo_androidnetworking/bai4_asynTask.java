package com.example.demo_androidnetworking;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class bai4_asynTask extends AsyncTask<String ,Void,String> {
    private ProgressDialog dialog;
    TextView tvResult;
    EditText txtTime;
    Context context;
    String kq ;

    public   bai4_asynTask(Context context, TextView tvResult,EditText txtTime){
        this.context = context;
        this.tvResult = tvResult;
        this.txtTime = txtTime;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context,"Tittle","Xin doi : "+txtTime.getText().toString()+"giay");
    }

    @Override
    protected String doInBackground(String... strings) {
        // publishProgress("Sleeping");
        try {
            int time  = Integer.parseInt(strings[0])+1000;
            Thread.sleep(time);
            kq = "Sleeped in " +strings[0] +"giay";

        } catch (InterruptedException e) {
            e.printStackTrace();
            kq = e.getMessage();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(dialog.isShowing()){
            dialog.dismiss();
        }
        tvResult.setText(s);
    }
}
