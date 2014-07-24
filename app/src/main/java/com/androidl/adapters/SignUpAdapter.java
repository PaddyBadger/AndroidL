package com.androidl.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;
import android.support.v7.graphics.PaletteItem;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidl.R;
import com.androidl.model.Child;
import com.androidl.model.Data_;
import com.androidl.model.Reddit;

/**
 * Created by patriciaestridge on 7/21/14.
 */
public class SignUpAdapter extends RecyclerView.Adapter<SignUpAdapter.ViewHolder> {
    private Context context;
    private Reddit redditData;
    private int itemLayout;

    public SignUpAdapter(Context context, Reddit redditData, int itemLayout)
    {
        super();
        this.context = context;
        this.redditData = redditData;
        this.itemLayout = itemLayout;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        Child child = redditData.getData().getChildren().get(i);
        Data_ data = child.getData();

        viewHolder.text.setText(data.getTitle());
        ImageView imageView = viewHolder.image;
        imageView.setImageBitmap(child.getBm());
        Bitmap image = child.getBm();
        if (image != null)
        {
            Palette p = Palette.generate(image, 24);

            final PaletteItem darkColor = p.getDarkVibrantColor() != null ? p.getDarkVibrantColor() : p.getDarkMutedColor();

            viewHolder.text.setBackgroundColor(darkColor.getRgb());
        }
        viewHolder.itemView.setTag(data);

//        viewHolder.image.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(context, SecondActivity.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override public int getItemCount() {
        return redditData.getData().getChildren().size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
