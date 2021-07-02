package com.example.demo_androidnetworking;

import android.graphics.Bitmap;

public interface Listener {
    void onImageDownload(Bitmap bitmap);
    void onError();
}
