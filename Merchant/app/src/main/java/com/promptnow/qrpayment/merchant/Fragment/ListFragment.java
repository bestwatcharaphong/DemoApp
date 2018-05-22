package com.promptnow.qrpayment.merchant.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.promptnow.qrpayment.merchant.Activity.MainActivity;
import com.promptnow.qrpayment.merchant.Activity.PersonActivity;
import com.promptnow.qrpayment.merchant.Adapter.TransactionBaseAdapter;
import com.promptnow.qrpayment.merchant.Model.TransactionModel;
import com.promptnow.qrpayment.merchant.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.AppCompatDrawableManager.get;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    View rootview;
    ListView listView;
    TransactionBaseAdapter tranAdapter;
    ArrayList<TransactionModel>tran = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
    }
    public static ListFragment newIntance(ArrayList<TransactionModel> transaction) {
        ListFragment list = new ListFragment();
        Bundle args = new Bundle();
        Parcelable pacel = Parcels.wrap(transaction);
        args.putParcelable("123", pacel);
        list.setArguments(args);
        return list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tran = Parcels.unwrap(getArguments().getParcelable("123"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_list, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = rootview.findViewById(R.id.listview);
        tranAdapter = new TransactionBaseAdapter(getActivity(),tran);
        listView.setAdapter(tranAdapter);
        tranAdapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


              Intent intent = new Intent(getActivity(),PersonActivity.class);
              TransactionModel transaction = tran.get(position);
              intent.putExtra("1234",Parcels.wrap(transaction));
              startActivity(intent);


            }
        });
    }


}
