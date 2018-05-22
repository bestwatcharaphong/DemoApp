package com.promptnow.qrpayment.merchant.Fragment;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.promptnow.qrpayment.merchant.Activity.LoginActivity;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;
import com.promptnow.qrpayment.merchant.utility.MyDialogUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangepasswordFragment extends Fragment implements View.OnClickListener {

 private View rootview;
 private Button changpassword,logout;
 private Changepassword2Fragment changepassword2;
 private PaymentMerchantFragment payment_merchant;
 private String pass;

    public ChangepasswordFragment() {
        // Required empty public constructor
    }

    public static ChangepasswordFragment newInstance(String pass){
        ChangepasswordFragment fragment = new ChangepasswordFragment();
        Bundle args = new Bundle();
        args.putString("pass",pass);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      rootview = inflater.inflate(R.layout.fragment_change_password, container, false);
      return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        FragmentSetTitleBar titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("QR PAYMENT MERCHANT");

        initIntansce();

    }

    private void initIntansce() {
        changepassword2 = new Changepassword2Fragment();

        logout = rootview.findViewById(R.id.btn_logout);
        changpassword = rootview.findViewById(R.id.btn_click);
        logout.setOnClickListener(this);
        changpassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_click:
                //Toast.makeText(getContext(), "NONONO", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragtran = fragmentManager.beginTransaction();
                fragtran.replace(R.id.frame_change_password,new Changepassword2Fragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_logout:
                MyDialogUtility.defaultDialog(getContext(), "Logout Confirmation", "Are you sure to Logout?",
                        "You will returning to Login Screen", null, new MyDialogUtility.OnDialogClickListener() {
                            @Override
                            public void onDialogClickListener(AlertDialog dialog) {
                                dialog.dismiss();
                                getActivity().finish();
                            }
                        }, new MyDialogUtility.OnDialogClickListener() {
                            @Override
                            public void onDialogClickListener(AlertDialog dialog) {
                                dialog.dismiss();
                                startActivity(new Intent(getActivity(), LoginActivity.class));

                            }
                        }, null);
                break;

        }

    }
}
