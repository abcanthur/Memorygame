package com.memorygame.petermartinez.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by petermartinez on 8/16/16.
 */
public class CardImageAdapter extends BaseAdapter {
    private Context mContext;

    public CardImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return MainActivity.numberCards;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
//        TextView textView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
//            textView = new TextView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
//            textView = (TextView) convertView;
        }

        imageView.setImageResource(R.drawable.ic_android_24dp);
//        textView.setText(Cardghtyjtyj);

//        Picasso.with(mContext) //or we set the random picture
//                .load(asset.getId())
//                .placeholder(android.R.drawable.ic_dialog_alert)
//                .into(image);

        return imageView;
    }
}