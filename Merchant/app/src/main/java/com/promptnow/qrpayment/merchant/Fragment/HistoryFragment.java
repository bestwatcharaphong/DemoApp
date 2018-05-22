package com.promptnow.qrpayment.merchant.Fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.promptnow.qrpayment.merchant.Adapter.TransactionAdapter;
import com.promptnow.qrpayment.merchant.Adapter.TransactionBaseAdapter;
import com.promptnow.qrpayment.merchant.Model.CardType;
import com.promptnow.qrpayment.merchant.Model.TranCollectionModel;
import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.Model.TransactionType;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements View.OnClickListener {
    private View rootview;
    private Button btn_click1,btn_click2,btn_click3,btn_click4,btn_click5;
    private TextView formedate,todate;
    private Calendar mCurrentDate;
    int day,month,year;
    ArrayList<TranCollectionModel>out = new ArrayList<>();
    ArrayList<TransactionModel>inner = new ArrayList<>();
    ViewPager viewPager;
    TransactionAdapter transAdapter;
    //TransactionBaseAdapter adapter = new TransactionBaseAdapter(getActivity(),inner);


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_history, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentSetTitleBar titleBar = (FragmentSetTitleBar)getActivity();
        titleBar.setTitleBar("HISTORY");
        initIntance();
        initData();

    }

    private void initData() {
        inner.clear();
        out.clear();

        inner.add(new TransactionModel(11838,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4589","18 Jun 2017","13.51",true)
                 );
        inner.add(new TransactionModel(11839,
                TransactionType.TOPUP,8000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4580","10 Jun 2017","12.00",false)
        );
        inner.add(new TransactionModel(11789,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4559","17 Jun 2018","13.58",true)
        );
     inner.add(new TransactionModel(11456,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4559","18 Jun 2018","13.59",true)
        );
        inner.add(new TransactionModel(11458,
                TransactionType.TOPUP,800000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4552","18 Jun 2012","13.00",false)
        );
       inner.add(new TransactionModel(11478,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4553","18 Jun 2012","13.02",false)
        );
      inner.add(new TransactionModel(11254,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","17.00",false)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4558","18 Jun 2012","15.00",true)
        );
     inner.add(new TransactionModel(11254,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );



        out.add(new TranCollectionModel("bb",inner));
        inner.clear();

        inner.add(new TransactionModel(11838,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4589","09 Jun 2017","13.51",true)
        );
        inner.add(new TransactionModel(11839,
                TransactionType.TOPUP,8000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4580","10 Jun 2017","12.00",false)
        );
        inner.add(new TransactionModel(11789,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4559","17 Jun 2018","13.58",true)
        );
        inner.add(new TransactionModel(11456,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4559","18 Jun 2018","13.59",true)
        );
        inner.add(new TransactionModel(11458,
                TransactionType.TOPUP,800000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4552","18 Jun 2012","13.00",false)
        );
        inner.add(new TransactionModel(11478,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4553","18 Jun 2012","13.02",false)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","17.00",false)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4558","18 Jun 2012","15.00",true)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );



        inner.clear();


        inner.add(new TransactionModel(11838,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4589","09 Jun 2017","13.51",true)
        );
        inner.add(new TransactionModel(11839,
                TransactionType.TOPUP,8000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4580","10 Jun 2017","12.00",false)
        );
        inner.add(new TransactionModel(11789,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4559","17 Jun 2018","13.58",true)
        );
        inner.add(new TransactionModel(11456,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4559","18 Jun 2018","13.59",true)
        );
        inner.add(new TransactionModel(11458,
                TransactionType.TOPUP,800000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4552","18 Jun 2012","13.00",false)
        );
        inner.add(new TransactionModel(11478,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4553","18 Jun 2012","13.02",false)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.TOPUP,+4000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","17.00",false)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4558","18 Jun 2012","15.00",true)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );


        out.add(new TranCollectionModel("DD",inner));
        inner.clear();

        inner.add(new TransactionModel(15487,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4589","09 Jun 2017","13.51",true)
        );
        inner.add(new TransactionModel(11839,
                TransactionType.TOPUP,8000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4580","10 Jun 2017","12.00",false)
        );
        inner.add(new TransactionModel(11789,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4559","17 Jun 2018","13.58",true)
        );
        inner.add(new TransactionModel(11456,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4559","18 Jun 2018","13.59",true)
        );
        inner.add(new TransactionModel(11458,
                TransactionType.TOPUP,800000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4552","18 Jun 2012","13.00",false)
        );
        inner.add(new TransactionModel(11478,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4553","18 Jun 2012","13.02",false)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","17.00",false)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4558","18 Jun 2012","15.00",true)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );




        out.add(new TranCollectionModel("EE",inner));
        inner.clear();

        inner.add(new TransactionModel(11838,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4589","09 Jun 2017","13.51",true)
        );
        inner.add(new TransactionModel(11839,
                TransactionType.TOPUP,8000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4580","10 Jun 2017","12.00",false)
        );
        inner.add(new TransactionModel(11789,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4559","17 Jun 2018","13.58",true)
        );
        inner.add(new TransactionModel(11456,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4559","18 Jun 2018","13.59",true)
        );
        inner.add(new TransactionModel(11458,
                TransactionType.TOPUP,800000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4552","18 Jun 2012","13.00",false)
        );
        inner.add(new TransactionModel(11478,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4553","18 Jun 2012","13.02",false)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.TOPUP,4000,
                "Gundom online shop", CardType.JCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","17.00",false)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.MIZUHO,"xxxx-xxxx-xxxx-4558","18 Jun 2012","15.00",true)
        );
        inner.add(new TransactionModel(11254,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );
        inner.add(new TransactionModel(11457,
                TransactionType.PAYMENT,-4000,
                "Gundom online shop", CardType.SMCC,"xxxx-xxxx-xxxx-4555","18 Jun 2012","12.00",true)
        );

        out.add(new TranCollectionModel("GG",inner));

        transAdapter = new TransactionAdapter(getChildFragmentManager(),out);
        viewPager.setAdapter(transAdapter);
        transAdapter.notifyDataSetChanged();
    }

    private void initIntance() {
        formedate = rootview.findViewById(R.id.tv_start_date);
        todate    = rootview.findViewById(R.id.tv_To_Date);
        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year  =  mCurrentDate.get(Calendar.YEAR);
        month = month+1;
        todate.setOnClickListener(this);
        formedate.setOnClickListener(this);
        formedate.setText(day+"/"+month+"/"+year);
        todate.setText(day+"/"+month+"/"+year);

        viewPager= rootview.findViewById(R.id.viewPager);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_start_date:
                DatePickerDialog Start_Date = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        formedate.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                Start_Date.show();
                break;
            case R.id.tv_To_Date:
                final DatePickerDialog To_Date = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        todate.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,year);
                To_Date.show();
                break;

        }
    }
}
