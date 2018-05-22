package com.promptnow.qrpayment.merchant.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment implements View.OnClickListener{

    private View rootview;
    private EditText edt_user;
    private Button cancel, ok;

    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_payment, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentSetTitleBar titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("PAYMENT");

        initIntansce();

    }

    private void initIntansce() {
        ok = rootview.findViewById(R.id.btn_ok);
        cancel = rootview.findViewById(R.id.btn_cancel);
        edt_user = rootview.findViewById(R.id.edt_user);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == cancel) {
            getActivity().finish();
        }else if(view ==ok){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragtran = fragmentManager.beginTransaction();
            fragtran.replace(R.id.frame_payment,new ScandFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
