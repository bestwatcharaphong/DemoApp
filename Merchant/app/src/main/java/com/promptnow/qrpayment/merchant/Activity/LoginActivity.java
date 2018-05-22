package com.promptnow.qrpayment.merchant.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.promptnow.qrpayment.merchant.Fragment.LoginFragment;
import com.promptnow.qrpayment.merchant.R;

public class LoginActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        

        getWindow().setStatusBarColor(getResources().getColor(R.color.overlay));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.framelayout, new LoginFragment())
                    .commit();
        }
    }
}
