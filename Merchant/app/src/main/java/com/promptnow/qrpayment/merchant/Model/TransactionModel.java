package com.promptnow.qrpayment.merchant.Model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;


@Parcel
public class TransactionModel {
    int transactionID;
    TransactionType transactionType;
    double totalamount;
    String name;
    CardType cardType;
    String cardnum;
    String date;
    String time;
    boolean tranStatus;

    @ParcelConstructor
    public TransactionModel(int transactionID, TransactionType transactionType,
                            double totalamount, String name, CardType cardType,
                            String cardnum, String date, String time, boolean tranStatus) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.totalamount = totalamount;
        this.name = name;
        this.cardType = cardType;
        this.cardnum = cardnum;
        this.date = date;
        this.time = time;
        this.tranStatus = tranStatus;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totleamount) {
        this.totalamount = totleamount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardnume() {
        return cardnum;
    }

    public void setCardnume(String cardname) {
        this.cardnum = cardnum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isTranStatus() {
        return tranStatus;
    }

    public void setTranStatus(boolean tranStatus) {
        this.tranStatus = tranStatus;
    }
}
