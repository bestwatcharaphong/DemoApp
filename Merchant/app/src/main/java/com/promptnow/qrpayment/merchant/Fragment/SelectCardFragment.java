package com.promptnow.qrpayment.merchant.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.promptnow.qrpayment.merchant.Adapter.CardTypeAdapter;
import com.promptnow.qrpayment.merchant.Model.CardModel;
import com.promptnow.qrpayment.merchant.Model.CardType;
import com.promptnow.qrpayment.merchant.R;
import com.promptnow.qrpayment.merchant.View.FragmentSetTitleBar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectCardFragment extends Fragment {

    private View rootview;
    private ListView listView;
    private CardModel cardModel;
    private ArrayList<CardModel> cardList = new ArrayList<>();
    private CardTypeAdapter adapter;

    public SelectCardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_selectcard, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentSetTitleBar titleBar = (FragmentSetTitleBar) getActivity();
        titleBar.setTitleBar("SELECT CARD");

        initInstance(rootview);
    }

    private void initInstance(View rootview) {

        listView = rootview.findViewById(R.id.listView);
        initData();

    }

    private void initData() {

        cardList.clear();
        cardList.add(new CardModel(CardType.JCC, getString(R.string.jcb_premo)));
        cardList.add(new CardModel(CardType.SMCC, getString(R.string.smcc)));
        cardList.add(new CardModel(CardType.MIZUHO, getString(R.string.mizuho)));
        adapter = new CardTypeAdapter(getActivity(), cardList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_sectCard, GenerateFragment.newInstance(cardList.get(i)))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

}

