package com.promptnow.qrpayment.merchant.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.promptnow.qrpayment.merchant.R;

/**
 * Created by watch on 3/5/2018.
 */

class CustomButtomGenQr extends FrameLayout{
    public CustomButtomGenQr(@NonNull Context context) {
        super(context);
        InitsIntance();
    }

    public CustomButtomGenQr(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        InitsIntance();
    }

    public CustomButtomGenQr(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        InitsIntance();
    }

    public CustomButtomGenQr(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        InitsIntance();
    }
    private void InitsIntance(){
        inflate(getContext(),R.layout.layout_gen,this);
    }



}
