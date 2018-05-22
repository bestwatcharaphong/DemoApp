package com.promptnow.qrpayment.merchant.Model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.ArrayList;

/**
 * Created by watch on 3/23/2018.
 */

@Parcel
public class TranCollectionModel {
    String test;
    ArrayList<TransactionModel>transaction;

    @ParcelConstructor
    public TranCollectionModel(String test, ArrayList<TransactionModel> transaction) {
        this.test = test;
        this.transaction = transaction;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public ArrayList<TransactionModel> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<TransactionModel> transaction) {
        this.transaction = transaction;
    }


}
