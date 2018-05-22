package com.promptnow.qrpayment.merchant.Fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.promptnow.qrpayment.merchant.Model.CardModel;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

import org.parceler.Parcels;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenerateFragment extends Fragment implements View.OnClickListener{

    private ImageView image;
    private View rootview;
    private TextView tv_count;
    private Button btn_cancel;
    private CountDownTimer countDownTimer;

    public GenerateFragment() {
        // Required empty public constructor
    }

    public static GenerateFragment newInstance(CardModel cardModel){
        GenerateFragment fragment = new GenerateFragment();
        Bundle args = new Bundle();
        args.putParcelable("Card", Parcels.wrap(cardModel));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_genqrcode, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentSetTitleBar titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("GEN QR");

        InitInstance();
    }

    private void InitInstance() {

        image = rootview.findViewById(R.id.image);
        tv_count = rootview.findViewById(R.id.tv_count);
        btn_cancel = rootview.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        ShowQR();
    }

    public void ShowQR() {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode("0123456789", BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }

        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                tv_count.setText("( " + l / 1000 + " )");
            }

            @Override
            public void onFinish() {
                getActivity().finish();
            }
        }.start();

    }

    @Override
    public void onPause() {
        super.onPause();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_cancel:
                countDownTimer.cancel();
                getActivity().finish();
                break;
        }

    }

}
