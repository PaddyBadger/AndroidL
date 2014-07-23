package com.androidl.activities;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.androidl.R;

public class BaseActivity extends FragmentActivity {


    private Handler mHandler;
    private int[] mMenuItemIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    public static final String FRAGMENT_TAG = "content";

    protected void initViews(String title, int icon, Fragment fragment) {
        setContentView(R.layout.activity_my);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment, FRAGMENT_TAG).commit();
        setTitle(title);
        initActionBar();

    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();

        Typeface titletf = Typeface.createFromAsset(this.getAssets(), "fonts/quigley.ttf");

        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
    }

}
