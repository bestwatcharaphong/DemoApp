package com.promptnow.qrpayment.merchant.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.promptnow.qrpayment.merchant.R;

/**
 * Created by watch on 3/14/2018.
 */

public class CustomButtonmizuho extends FrameLayout {
    public CustomButtonmizuho(@NonNull Context context) {
        super(context);
        initIntance();
    }

    public CustomButtonmizuho(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initIntance();
    }

    public CustomButtonmizuho(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initIntance();
    }

    public CustomButtonmizuho(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initIntance();
    }
    private void initIntance(){
        inflate(getContext(), R.layout.layout_mizuho,this);
    }

}
