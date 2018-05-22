package com.promptnow.qrpayment.merchant.Fragment;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.promptnow.qrpayment.merchant.Activity.Changepassword_Activity;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;
import com.promptnow.qrpayment.merchant.utility.MyDialogUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class Changepassword2Fragment extends Fragment implements View.OnClickListener{

    private  View rootview;
    private  Button submit,cancel;
    private  String pass;
    private  EditText currentpass,newpass,confrim;
    private  String Newpass;
    private  String Confrim;


    public Changepassword2Fragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_changepassword2, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentSetTitleBar  titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("QR PAYMENT MERCHANT");
        initInstance();

    }

    private void initInstance() {

        submit = rootview.findViewById(R.id.btn_ok);
        cancel = rootview.findViewById(R.id.btn_cancel);
        currentpass = rootview.findViewById(R.id.current_password);
        newpass = rootview.findViewById(R.id.edt_newpassword);
        confrim = rootview.findViewById(R.id.edt_confrimpass);
        Newpass = newpass.getText().toString();
        Confrim = confrim.getText().toString();
        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        String Current = currentpass.getText().toString();
        String NewPass = newpass.getText().toString();
        String Confrim = confrim.getText().toString();
        pass = getActivity().getIntent().getStringExtra("pass");

        if(view == submit){
           // Toast.makeText(getContext(),Current, Toast.LENGTH_SHORT).show();
            if(pass.equals(Current)){
                MyDialogUtility.customDialog(getActivity(), true, "Chang Password Complete!",
                        "Password Changing is successful.", "return back to Main Screen", new MyDialogUtility.OnDialogClickListener() {
                            @Override
                            public void onDialogClickListener(AlertDialog dialog) {
                                dialog.dismiss();
                                getActivity().finish();
                            }
                        });
            }else{
                MyDialogUtility.customDialog(getActivity(), false, "Chang Password Fail !",
                        "Password Changing is filed", "Please try again", new MyDialogUtility.OnDialogClickListener() {
                            @Override
                            public void onDialogClickListener(AlertDialog dialog) {
                                dialog.dismiss();
                                currentpass.setText("");
                                newpass.setText("");
                                confrim.setText("");
                                getActivity();
                            }
                        });
            }
        }else if(view == cancel){
            startActivity(new Intent(getActivity(), Changepassword_Activity.class));
        }
    }


}
