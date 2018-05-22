package com.promptnow.qrpayment.merchant.Activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.Model.CardType;
import com.promptnow.qrpayment.merchant.R;

import static com.promptnow.qrpayment.merchant.Model.CardType.SMCC;

/**
 * Created by watch on 3/18/2018.
 */

public class CustomListCard extends FrameLayout {

    private ImageView img_IconCard;
    private TextView tv_CardName;

    public CustomListCard(@NonNull Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public CustomListCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public CustomListCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }

    public CustomListCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInflate(){
        inflate(getContext(), R.layout.layout_list_card,this);

    }
    private void initInstance(){

        img_IconCard = findViewById(R.id.img_IconCard);
        tv_CardName = findViewById(R.id.tv_CardName);
    }

    public void setCard(CardType cardType, String cardName){
        switch (cardType){
            case JCC:
                img_IconCard.setImageResource(R.drawable.ic_jcb);
                tv_CardName.setText(cardName);
                break;
            case SMCC:
                img_IconCard.setImageResource(R.drawable.ic_smcc);
                tv_CardName.setText(cardName);
                break;
            case MIZUHO:
                img_IconCard.setImageResource(R.drawable.ic_mizuho);
                tv_CardName.setText(cardName);
                break;
        }
    }
}
