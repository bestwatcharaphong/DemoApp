package com.promptnow.qrpayment.merchant.Fragment;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TextView;
import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;
import com.promptnow.qrpayment.merchant.utility.MyDialogUtility;

import org.parceler.Parcels;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment implements View.OnClickListener {
   TransactionModel transactionModel;
   View rootview;
   private TextView tranID,tranType,
                    tranStatus,tranAmount,
                    tranName,tranCardType,
                    tranCardnumber,tranDate,
                     tranTime;
   LinearLayout tv_title,linear_button;
   Button cancel,button_yes,button_no;
    public PersonFragment() {
        // Required empty public constructor
    }
    public static PersonFragment newIntance(TransactionModel transaction) {
        PersonFragment person = new PersonFragment();
        Bundle args = new Bundle();
        args.putParcelable("1234",Parcels.wrap(transaction));
        person.setArguments(args);
        return person;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transactionModel = Parcels.unwrap(getArguments().getParcelable("1234"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       rootview =  inflater.inflate(R.layout.fragment_person, container, false);
       return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FragmentSetTitleBar titleBar = (FragmentSetTitleBar)getActivity();
        titleBar.setTitleBar("HISTORY");
        super.onViewCreated(view, savedInstanceState);
        InitInstance();
    }

    private void InitInstance() {
        tranID = rootview.findViewById(R.id.tv_tranID);
        cancel = rootview.findViewById(R.id.btn_cancel);
        tranType = rootview.findViewById(R.id.tv_tranType);
        tranAmount = rootview.findViewById(R.id.tv_amount);
        tranName = rootview.findViewById(R.id.tv_name);
        tranCardType = rootview.findViewById(R.id.tv_Cardtype);
        tranCardnumber = rootview.findViewById(R.id.tv_Cardnum);
        tranDate = rootview.findViewById(R.id.tv_date);
        tranTime = rootview.findViewById(R.id.tv_time);
        tv_title = rootview.findViewById(R.id.line);
        linear_button = rootview.findViewById(R.id.button_layout);
        button_yes = rootview.findViewById(R.id.btn_yes);
        button_no  = rootview.findViewById(R.id.btn_no);

        tranID.setText(transactionModel.getTransactionID()+"");
        tranType.setText(transactionModel.getTransactionType().getName());
        tranAmount.setText(transactionModel.getTotalamount()+"");
        tranName.setText(transactionModel.getName());
        tranCardType.setText(transactionModel.getCardType().getName());
        tranCardnumber.setText(transactionModel.getCardnume());
        tranDate.setText(transactionModel.getDate());
        tranTime.setText(transactionModel.getTime());
        /*if(transactionModel.isTranStatus() == true){
            tranStatus.setText("Success");
        }else {
            tranStatus.setText("Fail");
        }*/

        cancel.setOnClickListener(this);
        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if(v == cancel){
          Animation anim = new AlphaAnimation(1.0f,0.0f);
          anim.setDuration(400);
          Animation anim2 = new AlphaAnimation(0.0f,1.0f);
          anim2.setDuration(400);
          Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.to_top);
           tv_title.startAnimation(animation);
           tv_title.setVisibility(View.VISIBLE);
           cancel.setAnimation(anim);
           cancel.setVisibility(View.GONE);
           linear_button.setAnimation(anim2);
           linear_button.setVisibility(View.VISIBLE);
        }else if(v == button_yes){

          if(transactionModel.isTranStatus() == true){
              MyDialogUtility.customDialog(getActivity(), true, "Cancellation is complete!",
                      "returning to history screen.", null, new MyDialogUtility.OnDialogClickListener() {
                          @Override
                          public void onDialogClickListener(AlertDialog dialog) {
                              dialog.dismiss();
                              getActivity().finish();
                          }
                      });
                    }else if(transactionModel.isTranStatus() == false){
              MyDialogUtility.customDialog(getActivity(), false, "Cancellation is filed!",
                      "returning to history screen.", null, new MyDialogUtility.OnDialogClickListener() {
                          @Override
                          public void onDialogClickListener(AlertDialog dialog) {
                              dialog.dismiss();
                              getActivity().finish();
                          }
                      });
                    }

      }else if(v == button_no){
          Animation anim = new AlphaAnimation(1.0f,0.0f);
          anim.setDuration(100);

         // Animation anim2 = new AlphaAnimation(0.0f,1.0f);
          anim.setDuration(100);
          Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.from_botton);
          tv_title.startAnimation(animation);
          tv_title.setVisibility(View.GONE);
          cancel.setAnimation(anim);
          cancel.setVisibility(View.VISIBLE);
          linear_button.setAnimation(anim);
          linear_button.setVisibility(View.GONE);


      }

    }
}
