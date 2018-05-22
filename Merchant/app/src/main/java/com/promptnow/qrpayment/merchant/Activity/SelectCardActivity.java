package com.promptnow.qrpayment.merchant.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Fragment.SelectCardFragment;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

public class SelectCardActivity extends AppCompatActivity  implements FragmentSetTitleBar{

    private Toolbar toolbar;
    private ImageView img_back;
    private TextView toolbar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);



        initInstance();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_sectCard, new SelectCardFragment())
                    .commit();

        }
    }

    private void initInstance() {

        toolbar = findViewById(R.id.toolbar);
        img_back = toolbar.findViewById(R.id.img_back);
        toolbar_title = findViewById(R.id.toolbar_title);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void setTitleBar(String text) {
       toolbar_title.setText(text);
    }
}
