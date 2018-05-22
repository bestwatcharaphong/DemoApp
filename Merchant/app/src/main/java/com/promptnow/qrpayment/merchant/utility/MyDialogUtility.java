package com.promptnow.qrpayment.merchant.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.SpinView;

/**
 * Created by watch on 3/17/2018.
 */

public class MyDialogUtility {

    public interface OnDialogClickListener {
        void onDialogClickListener(AlertDialog dialog);
    }

    public static void defaultDialog(Context mContext, String title, String message1,
                                     String message2, final OnDialogClickListener listener,
                                     final OnDialogClickListener postListener,
                                     final OnDialogClickListener negaListener,
                                     OnDialogClickListener loadingListener) {

        AlertDialog.Builder builderDialog = new AlertDialog.Builder(mContext);
        View dialogView = View.inflate(mContext, R.layout.dialog_logout, null);
        builderDialog.setView(dialogView);

        TextView dialogTitle = dialogView.findViewById(R.id.dialogTitle);
        TextView dialogMessage1 = dialogView.findViewById(R.id.dialogMessage1);
        TextView dialogMessage2 = dialogView.findViewById(R.id.dialogMessage2);
        final Button dialogOK = dialogView.findViewById(R.id.btn_ok);
        Button dialogCancel = dialogView.findViewById(R.id.btn_cancel);
        SpinView dialogLoading = dialogView.findViewById(R.id.progressBar);

        final AlertDialog dialog = builderDialog.create();
        dialog.show();

        if (title != null) {
            dialogTitle.setText(title);
        } else {
            dialogTitle.setVisibility(View.GONE);
        }
        if (message1 != null) {
            dialogMessage1.setText(message1);
        } else {
            dialogMessage1.setVisibility(View.GONE);
        }
        if (message2 != null) {
            dialogMessage2.setText(message2);
        } else {
            dialogMessage2.setVisibility(View.GONE);
        }

        if (listener == null) {
            dialogOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDialogClickListener(dialog);
                }
            });
        }
        if (postListener != null) {
            dialogCancel.setVisibility(View.VISIBLE);
            dialogCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    postListener.onDialogClickListener(dialog);
                }
            });
        } else {
            dialogCancel.setVisibility(View.GONE);
        }

        if (negaListener != null) {
            dialogOK.setVisibility(View.VISIBLE);
            dialogOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (negaListener != null) {
                        negaListener.onDialogClickListener(dialog);
                    }
                }
            });
        } else {
            dialogOK.setVisibility(View.GONE);
        }

        if (loadingListener != null) {
            dialogLoading.setVisibility(View.VISIBLE);
            loadingListener.onDialogClickListener(dialog);
        }

    }

    public static void customDialog(Context mContext, boolean stateDiolog, String title,
                                    String message1, String message2,
                                    final OnDialogClickListener listener) {

        final AlertDialog.Builder builderDialog = new AlertDialog.Builder(mContext);
        View dialogView = View.inflate(mContext, R.layout.dialog_change_complete, null);
        builderDialog.setView(dialogView);

        ImageView dialogImageSuccess = dialogView.findViewById(R.id.img_success);
        TextView dialogTitle = dialogView.findViewById(R.id.tv_Title);
        TextView dialogMessage = dialogView.findViewById(R.id.tv_Message1);
        TextView dialogMessage2 = dialogView.findViewById(R.id.tv_Message2);
        Button btnOK = dialogView.findViewById(R.id.btn_ok);

        final AlertDialog dialog = builderDialog.create();
        dialog.show();
        if (message1 != null) {
            dialogMessage.setText(message1);
        }

        if (message2 != null) {
            dialogMessage2.setText(message2);
        } else {
            dialogMessage2.setVisibility(View.GONE);
        }

        if (stateDiolog) {
            dialogImageSuccess.setImageResource(R.drawable.ic_true);
            if (title != null) {
                dialogTitle.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
                dialogTitle.setText(title);
            }
        } else {
            dialogImageSuccess.setImageResource(R.drawable.ic_false);
            if (title != null) {
                dialogTitle.setTextColor(mContext.getResources().getColor(R.color.colorRed));
                dialogTitle.setText(title);
            }
        }

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDialogClickListener(dialog);
                }
            }
        });

    }

}
