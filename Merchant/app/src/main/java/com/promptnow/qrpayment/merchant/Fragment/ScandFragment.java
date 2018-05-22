package com.promptnow.qrpayment.merchant.Fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;
import com.promptnow.qrpayment.merchant.utility.MyDialogUtility;

import java.io.IOException;

public class ScandFragment extends Fragment implements View.OnClickListener {



    private View rootview;
    private SurfaceView cameraPreView;
    private TextView txtResult;
    private Button btn_cancel;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int RequestCameraPermissionID = 1001;

    public ScandFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_scandqr, container, false);
        return rootview;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(cameraPreView.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentSetTitleBar titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("Scan QR");

       // payment_merchant = new PaymentMerchantFragment();
        Scand();
    }

    private void Scand() {

        cameraPreView = rootview.findViewById(R.id.cameraPreview);
        txtResult = rootview.findViewById(R.id.txtResult);
        btn_cancel = rootview.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        barcodeDetector = new BarcodeDetector.Builder(getActivity())
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();
        cameraSource = new CameraSource
                .Builder(getActivity(), barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        cameraPreView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA
                    }, RequestCameraPermissionID);
                    return;
                }
                try {
                    cameraSource.start(cameraPreView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrcode = detections.getDetectedItems();
                if (qrcode.size() != 0) {
                    txtResult.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator) getActivity().getSystemService(getActivity().VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                            MyDialogUtility.defaultDialog(getActivity(), "Loading", "QR code has been Successfully Scanned,",
                                    "Please wait, While we processing", null, null, null, new MyDialogUtility.OnDialogClickListener() {
                                        @Override
                                        public void onDialogClickListener(final AlertDialog dialog) {
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    dialog.dismiss();
                                                    if (qrcode.valueAt(0).displayValue.equals("0123456789")) {
                                                        MyDialogUtility.customDialog(getActivity(), true, "Payment complete !",
                                                                "Returning to Home Screen", null, new MyDialogUtility.OnDialogClickListener() {
                                                                    @Override
                                                                    public void onDialogClickListener(AlertDialog dialog) {
                                                                        dialog.dismiss();
                                                                        getActivity().finish();
                                                                    }
                                                                });
                                                    }else {
                                                        MyDialogUtility.customDialog(getActivity(), false, "Payment Fail !",
                                                                "Returning to Home Screen", null, new MyDialogUtility.OnDialogClickListener() {
                                                                    @Override
                                                                    public void onDialogClickListener(AlertDialog dialog) {
                                                                        MyDialogUtility.customDialog(getActivity(), false, "Payment Fail !",
                                                                                "Please Contact our Customer Service.", null, new MyDialogUtility.OnDialogClickListener() {
                                                                                    @Override
                                                                                    public void onDialogClickListener(AlertDialog dialog) {
                                                                                        dialog.dismiss();
                                                                                        getActivity().finish();
                                                                                    }
                                                                                });
                                                                    }
                                                                });
                                                    }
                                                }
                                            }, 5000);
                                        }
                                    });
                            cameraSource.stop();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_cancel){
            getActivity().finish();
        }
    }
}
