package com.promptnow.qrpayment.merchant.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


import com.promptnow.qrpayment.merchant.Fragment.GenerateFragment;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

public class GenQRActivity extends AppCompatActivity implements FragmentSetTitleBar{
    private Toolbar toolbar;
    private ImageView back;
    private TextView tv_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genqr);
        initInstance();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_genQR, new GenerateFragment())
                    .commit();
        }
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        back    = findViewById(R.id.img_back);
        tv_toolbar = findViewById(R.id.toolbar_title);
    }

    @Override
    public void setTitleBar(String text) {
        tv_toolbar.setText(text);
    }
}
