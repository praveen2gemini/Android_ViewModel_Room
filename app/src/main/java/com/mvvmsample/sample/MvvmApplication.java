package com.mvvmsample.sample;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * @author Praveen on 30/05/18.
 */
public class MvvmApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
