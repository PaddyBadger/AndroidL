package com.androidl.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.androidl.R;
import com.androidl.adapters.SignUpAdapter;
import com.androidl.models.Savings;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by patriciaestridge on 7/21/14.
 */
public class SignUpFragment extends Fragment {

    private View rootView;
    private SignUpAdapter feedAdapter;
    private RecyclerView recyclerView;

    public static SignUpFragment newInstance()
    {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SignUpFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.inject(this, rootView);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.signup_list);
        List<Savings> savings = new ArrayList<Savings>();

        Savings savingone = new Savings();
        savingone.setTitle("TitleOne");
        savingone.setIcon("http://upload.wikimedia.org/wikipedia/commons/2/28/Flag_of_Puerto_Rico.svg");
        savings.add(savingone);

        Savings savingtwo = new Savings();
        savingone.setTitle("TitleTwo");
        savingone.setIcon("http://foundtheworld.com/wp-content/uploads/2014/03/Puerto-Rico-beaches-2.jpg");
        savings.add(savingtwo);

        Savings savingthree = new Savings();
        savingone.setTitle("TitleThree");
        savingone.setIcon("http://www.ashi.annualmeeting2012.org/sites/default/files/images/2012/PRBoat.jpg");
        savings.add(savingthree);

        savings.add(savingone);
        savings.add(savingtwo);
        savings.add(savingthree);

        feedAdapter = new SignUpAdapter(getActivity(), savings, R.layout.list_view);
        recyclerView.setAdapter(feedAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return rootView;
    }

}
