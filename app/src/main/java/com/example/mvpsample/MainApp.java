package com.example.mvpsample;

import android.app.Application;

public class MainApp extends Application {

    private static Application INSTANCE;

    public static Application getInstance(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
