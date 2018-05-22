package com.promptnow.qrpayment.merchant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.promptnow.qrpayment.merchant.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThred = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                    Intent intent = new Intent(Splash.this ,LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThred.start();

    }
}
