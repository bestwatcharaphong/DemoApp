package com.promptnow.qrpayment.merchant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Fragment.ChangepasswordFragment;
import com.promptnow.qrpayment.merchant.Fragment.ConfirmFragment;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

public class ConfirmActivity extends AppCompatActivity implements FragmentSetTitleBar, View.OnClickListener {
    private Toolbar toolbar;
    private ImageView img_back;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_confirm, new ConfirmFragment())
                    .commit();

            initInstance();
        }
    }

    @Override
    public void setTitleBar(String text) {

    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        img_back = findViewById(R.id.img_back);
        tv_title = findViewById(R.id.toolbar_title);
        img_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v ==img_back){
            startActivity(new Intent(getApplication(),PersonActivity.class));
        }
    }
}
