package com.promptnow.qrpayment.merchant.Model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by watch on 3/18/2018.
 */
@Parcel
public class CardModel {
    CardType cardType;
    String   cardName;

    @ParcelConstructor
    public CardModel(CardType cardType, String cardName) {
        this.cardType = cardType;
        this.cardName = cardName;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {

        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

}
