package com.androidl.api;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.androidl.model.Child;
import com.androidl.model.Reddit;
import com.squareup.picasso.Picasso;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Nakhimovich on 3/19/14.
 */
public class RestHelper {
    private static RestHelper ourInstance = new RestHelper();
    private static Context context;
    private RestTemplate restTemplate;

    public static RestHelper getInstance(Context context) {
        RestHelper.context = context;

        return ourInstance;
    }

    private RestHelper() {
        setupRestTemplate();

    }

    private void setupRestTemplate() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public Reddit getPosts()
    {
        String url = "http://www.reddit.com/r/aww.json?limit=10";
        Reddit reddit = restTemplate.getForObject(url, Reddit.class);
        for (Child child : reddit.getData().getChildren())
        {
            try
            {
                URL picurl = new URL(child.getData().getUrl());
                Bitmap bm = BitmapFactory.decodeStream(picurl.openConnection().getInputStream());
                child.setBm(bm);
            } catch (IOException e)
            {
            }
        }
        return reddit;
    }
}