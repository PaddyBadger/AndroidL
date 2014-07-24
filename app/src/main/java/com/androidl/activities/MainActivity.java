package com.androidl.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.androidl.R;
import com.androidl.fragments.SignUpFragment;

/**
 * Created by patriciaestridge on 7/21/14.
 */
public class MainActivity extends BaseActivity {
    public static void getLaunchIntent(Context context)
    {
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        initViews("RecycleView", R.drawable.ic_launcher, SignUpFragment.newInstance());
    }
}

