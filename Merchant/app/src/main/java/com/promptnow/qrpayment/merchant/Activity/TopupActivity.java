package com.promptnow.qrpayment.merchant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Fragment.TopupFragment;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

public class TopupActivity extends AppCompatActivity implements FragmentSetTitleBar, View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back;
    private TextView tv_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

         initInstance();
        if( savedInstanceState ==null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_topup, new TopupFragment())
                    .commit();
        }
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        back = findViewById(R.id.img_back);
        tv_toolbar = findViewById(R.id.toolbar_title);
        back.setOnClickListener(this);

    }


    @Override
    public void setTitleBar(String text) {
        tv_toolbar.setText(text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                startActivity(new Intent(getApplication(), MainActivity.class));
                break;
        }
    }
}
