package com.promptnow.qrpayment.merchant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Fragment.ChangepasswordFragment;
import com.promptnow.qrpayment.merchant.Fragment.ListFragment;
import com.promptnow.qrpayment.merchant.Fragment.PersonFragment;
import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

import org.parceler.Parcels;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity implements FragmentSetTitleBar, View.OnClickListener {
    private Toolbar toolbar;
    private ImageView img_back;
    private TextView tv_title;
    TransactionModel transactionModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        transactionModel = Parcels.unwrap(getIntent().getParcelableExtra("1234"));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_person,PersonFragment.newIntance(transactionModel))
                    .commit();
        }

        initInstance();
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        img_back = findViewById(R.id.img_back);
        tv_title = findViewById(R.id.toolbar_title);
        img_back.setOnClickListener(this);

    }

    @Override
    public void setTitleBar(String text) {
        tv_title.setText(text);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_back){
            startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
        }
    }
}


