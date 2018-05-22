package com.promptnow.qrpayment.merchant.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.View.CustomTran;

import java.util.ArrayList;

/**
 * Created by watch on 3/23/2018.
 */

public class TransactionBaseAdapter extends BaseAdapter{
    private Context mContex;

    ArrayList<TransactionModel>tran;

    public TransactionBaseAdapter(Context mContex, ArrayList<TransactionModel> tran) {
        this.mContex = mContex;
        this.tran = tran;
    }

    @Override
    public int getCount() {
        return tran.size();
    }

    @Override
    public Object getItem(int position) {
        return  tran.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomTran item;
        if(convertView != null){
            item = (CustomTran) convertView;
        }else{
            item = new CustomTran(mContex);
        }
        TransactionModel transactionModel = (TransactionModel)getItem(position);

        item.setTranID("Transaction ID  "+transactionModel.getTransactionID()+"");
        item.setType(transactionModel.getTransactionType().getName());
        item.setDate("Date "+ transactionModel.getDate()+", "+transactionModel.getTime());
        item.setMoney(transactionModel.getTotalamount());

        return item;
    }
}
