package com.example.user.testmvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 10/7/17.
 */

public class AppController extends Application {
    public static Context context;
    public static Context getContext(){
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
