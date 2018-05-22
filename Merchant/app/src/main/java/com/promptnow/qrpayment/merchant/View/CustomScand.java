package com.promptnow.qrpayment.merchant.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.promptnow.qrpayment.merchant.R;

/**
 * Created by watch on 3/7/2018.
 */

public class CustomScand extends FrameLayout {
    public CustomScand(@NonNull Context context) {
        super(context);
        initInflate();
    }

    public CustomScand(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
    }

    public CustomScand(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
    }

    public CustomScand(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
    }
    public void initInflate(){
        inflate(getContext(), R.layout.layout_scand,this);
    }

}
