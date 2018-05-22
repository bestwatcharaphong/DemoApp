package com.promptnow.qrpayment.merchant.Model;

import com.promptnow.qrpayment.merchant.R;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
/**
 * Created by watch on 3/18/2018.
 */
@Parcel
public enum CardType {
    JCC(R.string.jcb_premo),
    SMCC(R.string.smcc),
    MIZUHO(R.string.mizuho);

    private final int name;

    @ParcelConstructor
    CardType(int name) {
        this.name = name;
    }
    public int getName() {
        return  name;
    }


}
