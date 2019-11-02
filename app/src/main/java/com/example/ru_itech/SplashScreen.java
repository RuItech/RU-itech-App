package com.example.ru_itech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splash slash = new splash();
        slash.start();

    }

    public class splash extends Thread
    {

        @Override
        public void run() {

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent i = new Intent(SplashScreen.this,Login.class);
            startActivity(i);
            SplashScreen.this.finish();


        }
    }
}
