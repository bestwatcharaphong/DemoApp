package com.promptnow.qrpayment.merchant.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.promptnow.qrpayment.merchant.Activity.CustomListCard;
import com.promptnow.qrpayment.merchant.Model.CardModel;
import com.promptnow.qrpayment.merchant.Model.CardType;

import java.util.ArrayList;

/**
 * Created by watch on 3/18/2018.
 */

public class CardTypeAdapter extends BaseAdapter {


    Context mContext;
    ArrayList<CardModel> cardList;

    public CardTypeAdapter(Context mContext, ArrayList<CardModel> cardList) {
        this.mContext = mContext;
        this.cardList = cardList;
    }

    @Override
    public int getCount() {
        if (cardList == null){
            return 0;
        }
        if (cardList.size() == 0){
            return 0;
        }
        return cardList.size();
    }

    @Override
    public Object getItem(int i) {
        return cardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomListCard item;
        if (view != null){
            item = (CustomListCard) view;
        }else {
            item = new CustomListCard(mContext);
        }
        CardModel card = (CardModel) getItem(i);
        item.setCard(card.getCardType(), card.getCardName());
        return item;
    }
}
