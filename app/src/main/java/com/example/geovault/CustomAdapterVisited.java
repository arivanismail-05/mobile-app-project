package com.example.geovault;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geovault.Base.PlaceModel;

import java.util.ArrayList;

public class CustomAdapterVisited extends BaseAdapter {

    private ArrayList<PlaceModel> list;
    private Activity context;

    // کۆنستراکتەر بۆ وەرگرتنی لیستەکە و کۆنتێکست
    public CustomAdapterVisited(ArrayList<PlaceModel> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ئەگەر ڤیوەکە دروست نەکرابوو، دروستی بکە لە ڕێگەی LayoutInflater
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_visited, parent, false);
        }

        // دۆزینەوەی ئایتمەکە بەپێی پۆزیشن
        PlaceModel place = list.get(position);

        // دۆزینەوەی تێکست ڤیو و ئیمەیج ڤیووەکان لە ناو single_visited.xml
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvCategory = convertView.findViewById(R.id.tvCategory);
        ImageView imgCategory = convertView.findViewById(R.id.imgCategory);

        // دانانی داتاکان
        tvTitle.setText(place.getTitle());
        tvCategory.setText(place.getCategory());

        // بەکارهێنانی Glide بۆ نیشاندانی وێنەی کاتێگۆری
        Glide.with(context)
                .load(place.getImageUrl())
                .placeholder(R.drawable.marker_24)
                .into(imgCategory);

        return convertView;
    }
}