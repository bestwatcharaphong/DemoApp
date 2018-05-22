package com.promptnow.qrpayment.merchant.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.promptnow.qrpayment.merchant.Activity.MainActivity;
import com.promptnow.qrpayment.merchant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private View rootview;
    private EditText edit_User, edit_Pass;
    private Button btn_login;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_login, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInstance();
    }

    private void initInstance() {

        edit_User = rootview.findViewById(R.id.edt_user);
        edit_Pass = rootview.findViewById(R.id.edt_Pass);
        btn_login = rootview.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String user = edit_User.getText().toString();
                String pass = edit_Pass.getText().toString();
                if (!user.isEmpty() && !pass.isEmpty()) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                    getActivity().finish();
                }
                break;
        }
    }
}
