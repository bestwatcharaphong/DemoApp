package com.promptnow.qrpayment.merchant.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.promptnow.qrpayment.merchant.Fragment.PaymentMerchantFragment;
import com.promptnow.qrpayment.merchant.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main);

        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("pass");

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContener,  PaymentMerchantFragment.newInstance(user,pass))
                    .commit();

        }

    }
}
