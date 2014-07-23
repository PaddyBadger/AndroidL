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
        Bitmap icon = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.boatsunset);
        savingone.setIcon(icon);

        Savings savingtwo = new Savings();
        savingtwo.setTitle("TitleTwo");
        Bitmap icontwo = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.pr2);
        savingtwo.setIcon(icontwo);

        Savings savingthree = new Savings();
        savingthree.setTitle("TitleThree");
        Bitmap iconthree = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.puerto_ricco);
        savingthree.setIcon(iconthree);

        Savings savingfour = new Savings();
        savingfour.setTitle("TitleFour");
        Bitmap iconfour = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.hammock);
        savingfour.setIcon(iconfour);

        savings.add(savingone);
        savings.add(savingtwo);
        savings.add(savingthree);
        savings.add(savingfour);
        savings.add(savingone);
        savings.add(savingtwo);
        savings.add(savingthree);
        savings.add(savingfour);

        feedAdapter = new SignUpAdapter(getActivity(), savings, R.layout.list_view);
        recyclerView.setAdapter(feedAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return rootView;
    }

}
