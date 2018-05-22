package com.promptnow.qrpayment.merchant.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Activity.Changepassword_Activity;
import com.promptnow.qrpayment.merchant.Activity.HistoryActivity;
import com.promptnow.qrpayment.merchant.Activity.MainActivity;
import com.promptnow.qrpayment.merchant.Activity.SelectCardActivity;
import com.promptnow.qrpayment.merchant.Activity.TopupActivity;
import com.promptnow.qrpayment.merchant.View.CustomButtomTopup;
import com.promptnow.qrpayment.merchant.View.CustomScand;
import com.promptnow.qrpayment.merchant.View.CustomButtomGenQr;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.Activity.PaymentActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentMerchantFragment extends Fragment implements View.OnClickListener {

    private View rootview;
    private CustomButtomGenQr custom_genqr;
    private CustomScand custom_scandqr;
    private CustomButtomTopup custom_topup;
    private ImageView btnSetting;
    private Button history;
    private TextView date;
    private TextView tvUser;
    private String user;
    private String pass;


    public PaymentMerchantFragment() {

    }

    public static PaymentMerchantFragment newInstance(String user,String pass){
        PaymentMerchantFragment fragment = new PaymentMerchantFragment();
        Bundle args = new Bundle();
        args.putString("user", user);
        args.putString("pass",pass);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = getArguments().getString("user");
        pass = getArguments().getString("pass");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_permentmerchant,container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("M,dd,yyyy ");
        String formattedDate = df.format(c.getTime());

        date = rootview.findViewById(R.id.datetime);
        date.setText("Last login:"+formattedDate);

        custom_genqr = rootview.findViewById(R.id.custom_btn_genQR);
        custom_scandqr = rootview.findViewById(R.id.custom_btn_scadQR);
        custom_topup   = rootview.findViewById(R.id.custom_btn_top);
        tvUser = rootview.findViewById(R.id.tv_user);
        btnSetting = rootview.findViewById(R.id.btn_Setting);
        history = rootview.findViewById(R.id.btn_history);
        custom_genqr.setOnClickListener(this);
        custom_scandqr.setOnClickListener(this);
        custom_topup.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        history.setOnClickListener(this);
        initData();
    }

    private void initData() {

        tvUser.setText(user);
        //tvUser.setText(pass);

    }

    @Override
    public void onClick(View view) {
            // Toast.makeText(getContext(), "NONONO", Toast.LENGTH_SHORT).show();
            switch (view.getId()) {
                case R.id.custom_btn_genQR:
                    startActivity(new Intent(getActivity(), SelectCardActivity.class));
                    break;
                case R.id.custom_btn_scadQR:
                    startActivity(new Intent(getActivity(), PaymentActivity.class));
                    break;
                case R.id.custom_btn_top:
                    startActivity(new Intent(getActivity(), TopupActivity.class));

                    break;
                case R.id.btn_Setting:
                    Intent intent = new Intent(getActivity(), Changepassword_Activity.class);
                    //intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                    getActivity();
                    break;
                case R.id.btn_history:
                    startActivity(new Intent(getActivity(), HistoryActivity.class));
            }


    }
}
