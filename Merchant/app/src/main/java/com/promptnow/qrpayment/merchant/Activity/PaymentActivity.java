package com.promptnow.qrpayment.merchant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Fragment.PaymentFragment;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener,FragmentSetTitleBar {

    private Toolbar toolbar;
    private ImageView img_back;
    private TextView tv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);





        initInstance();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_payment, new PaymentFragment())
                    .commit();

        }
    }

    private void initInstance() {

        toolbar = findViewById(R.id.toolbar_top);
        tv_title = toolbar.findViewById(R.id.toolbar_title);
        img_back = toolbar.findViewById(R.id.img_back);
        img_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.img_back){
            startActivity(new Intent(getApplication(), MainActivity.class));
        }
    }

    @Override
    public void setTitleBar(String text) {
        tv_title.setText(text);
    }
}
