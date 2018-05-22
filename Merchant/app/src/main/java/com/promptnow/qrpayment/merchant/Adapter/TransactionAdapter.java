package com.promptnow.qrpayment.merchant.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.promptnow.qrpayment.merchant.Fragment.ListFragment;
import com.promptnow.qrpayment.merchant.Model.TranCollectionModel;

import java.util.ArrayList;

/**
 * Created by watch on 3/23/2018.
 */

public class TransactionAdapter extends FragmentStatePagerAdapter {

    ArrayList<TranCollectionModel>tranCollectionModels;

    public TransactionAdapter(FragmentManager fm, ArrayList<TranCollectionModel> tranCollectionModels) {
        super(fm);
        this.tranCollectionModels = tranCollectionModels;

    }

    @Override
    public Fragment getItem(int position) {
        return ListFragment.newIntance(tranCollectionModels.get(position).getTransaction());
    }

    @Override
    public int getCount() {
        return tranCollectionModels.size();
    }
}
