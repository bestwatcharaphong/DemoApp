package com.promptnow.qrpayment.merchant.Model;

import com.promptnow.qrpayment.merchant.R;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by watch on 3/23/2018.
 */

@Parcel
public enum TransactionType {
     PAYMENT(R.string.paymenti)
    ,TOPUP(R.string.top_up);

    private final int name;
     @ParcelConstructor
    TransactionType(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }
}
