package com.androidl.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.PaletteItem;
import android.transition.Explode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidl.R;

/**
 * Created by patriciaestridge on 7/24/14.
 */
public class SecondActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());


        setContentView(R.layout.activity_second_layout);

        ImageView image = (ImageView) findViewById(R.id.image);

        Bitmap image1 = MainActivity.image;
        image.setImageBitmap(image1);

        TextView text = (TextView) findViewById(R.id.title);
        text.setText(getIntent().getStringExtra("title"));
        Palette p = Palette.generate(image1, 24);

        final PaletteItem darkColor = p.getDarkVibrantColor() != null ? p.getDarkVibrantColor() : p.getDarkMutedColor();
        text.setBackgroundColor(darkColor.getRgb());
    }
}
