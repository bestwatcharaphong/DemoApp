package com.promptnow.qrpayment.merchant.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.promptnow.qrpayment.merchant.Activity.MainActivity;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopupFragment extends Fragment implements View.OnClickListener {
    View rootview;
    Button cancel,ok;




    public TopupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_topup, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentSetTitleBar titleBar = (FragmentSetTitleBar)getActivity();
        titleBar.setTitleBar("TOP UP");


        ok     = rootview.findViewById(R.id.btn_ok);
        cancel = rootview.findViewById(R.id.btn_cancel);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == cancel){
            startActivity(new Intent(getActivity(), MainActivity.class));
        }else if(v ==ok){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragtra = fragmentManager.beginTransaction();
            fragtra.replace(R.id.frame_topup,new ScandtopupFragment())
                    .addToBackStack(null)
                    .commit();

        }
    }
}
