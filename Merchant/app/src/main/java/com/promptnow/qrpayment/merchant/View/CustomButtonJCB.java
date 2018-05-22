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

public class CustomButtonJCB extends FrameLayout {
    public CustomButtonJCB(@NonNull Context context) {
        super(context);
        initIntace();
    }

    public CustomButtonJCB(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initIntace();
    }

    public CustomButtonJCB(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initIntace();
    }

    public CustomButtonJCB(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initIntace();
    }

    private void initIntace() {
        {
            inflate(getContext(), R.layout.layout_jcb, this);
        }
    }
}
