package com.promptnow.qrpayment.merchant.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.R;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {
    TransactionModel transactionModel;
    View rootview;
    private TextView tranID,tranType,
            tranStatus,tranAmount,
            tranName,tranCardType,
            tranCardnumber,tranDate,
            tranTime;
    Button cancel;

    public static ConfirmFragment newIntance(TransactionModel transaction) {
        ConfirmFragment confirm = new ConfirmFragment();
        Bundle args = new Bundle();
        args.putParcelable("1234", Parcels.wrap(transaction));
        confirm.setArguments(args);
        return confirm;
    }


    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_confirm, container, false);
        return rootview;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitInstance();
    }

    private void InitInstance() {

        tranID = rootview.findViewById(R.id.tv_tranID);
        tranType = rootview.findViewById(R.id.tv_tranType);
        tranAmount = rootview.findViewById(R.id.tv_amount);
        tranName = rootview.findViewById(R.id.tv_name);
        tranCardType = rootview.findViewById(R.id.tv_Cardtype);
        tranCardnumber = rootview.findViewById(R.id.tv_Cardnumber);
        tranDate = rootview.findViewById(R.id.tv_trandate);
        tranTime = rootview.findViewById(R.id.tv_trantime);
        tranStatus = rootview.findViewById(R.id.tv_tranStatus);
        cancel = rootview.findViewById(R.id.btn_cancel);
        tranID.setText(transactionModel.getTransactionID()+"");
        tranType.setText(transactionModel.getTransactionType().getName());
        tranAmount.setText(transactionModel.getTotalamount()+"");
        tranName.setText(transactionModel.getName());
        tranCardType.setText(transactionModel.getCardType().getName());
        tranCardnumber.setText(transactionModel.getCardnume());
        tranDate.setText(transactionModel.getDate());
        tranTime.setText(transactionModel.getTime());
        if(transactionModel.isTranStatus() == true){
            tranStatus.setText("Success");
        }else {
            tranStatus.setText("Fail");
        }


    }

}
