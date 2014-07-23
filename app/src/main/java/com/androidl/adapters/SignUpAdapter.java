package com.androidl.adapters;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidl.R;
import com.androidl.models.Savings;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patriciaestridge on 7/21/14.
 */
public class SignUpAdapter extends RecyclerView.Adapter<SignUpAdapter.ViewHolder> {
    public List<Savings> savings = new ArrayList<Savings>();
    private Context context;
    private int itemLayout;

    public SignUpAdapter(Context context, List<Savings> savings, int itemLayout)
    {
        super();
        this.context = context;
        this.savings = savings;
        this.itemLayout = itemLayout;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Savings item = savings.get(i);
        viewHolder.text.setText(item.getTitle());
        viewHolder.image.setImageBitmap(item.getIcon());

//        Picasso.with(viewHolder.image.getContext()).cancelRequest(viewHolder.image);
//        Picasso.with(viewHolder.image.getContext()).load(item.getIcon()).into(viewHolder.image);
        viewHolder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return savings.size();
    }

    public void add(Savings item, int position) {
        savings.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Savings item) {
        int position = savings.indexOf(item);
        savings.remove(position);
        notifyItemRemoved(position);
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
