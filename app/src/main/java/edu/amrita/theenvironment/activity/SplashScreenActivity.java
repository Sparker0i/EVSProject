package edu.amrita.theenvironment.activity;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.ExecutionException;

import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.app.App;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final App global = (App) getApplicationContext();
                try {
                    global.init();
                }
                catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
