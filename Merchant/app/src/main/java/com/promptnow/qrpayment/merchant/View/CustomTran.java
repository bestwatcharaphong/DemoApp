package com.promptnow.qrpayment.merchant.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.R;

/**
 * Created by watch on 3/23/2018.
 */

public class CustomTran extends FrameLayout {
    private TextView tranID,date,type,current,money,tran_status;

    public CustomTran(@NonNull Context context) {
        super(context);
        initInfate();
        initIntance();
    }

    public CustomTran(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInfate();
        initIntance();
    }

    public CustomTran(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInfate();
        initIntance();
    }
    private void initInfate(){
        inflate(getContext(), R.layout.customtran_layout,this);
    }

    private void initIntance(){
        tranID = findViewById(R.id.tv_label_tranID);
        date   = findViewById(R.id.date);
        type   = findViewById(R.id.type);
        current = findViewById(R.id.current);
        money = findViewById(R.id.monney);

    }
    public void setTranID(String TranID){
        tranID.setText(TranID);
    }
    public void setDate(String Date){
        date.setText(Date);

    }
    public void setType(int  Trantype){
        type.setText(getResources().getString(Trantype));

    }
    public void setCurrent(String tranCurrent){
        current.setText(tranCurrent);

    }
    public void setMoney(Double  TranMoney){
        if(TranMoney >0){
            money.setText("+ "+TranMoney);
        }else{
            money.setText(" "+TranMoney);
            money.setTextColor(getResources().getColor(R.color.black));
        }
    }

}
