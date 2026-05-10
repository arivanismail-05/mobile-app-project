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

    private ArrayList<PlaceModel> places;
    private Activity context;

    public CustomAdapterVisited(ArrayList<PlaceModel> places, Activity context) {
        this.places = places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_visited, parent, false);
        }

        PlaceModel place = places.get(i);

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvCategory = convertView.findViewById(R.id.tvCategory);
        ImageView imgCategory = convertView.findViewById(R.id.imgCategory);
        TextView tvTime = convertView.findViewById(R.id.tvTime);

        tvTitle.setText(place.getTitle());
        tvCategory.setText(place.getCategory());
        tvTime.setText(place.getLocation());


        Glide.with(context)
                .load(place.getImageUrl())
                .placeholder(R.drawable.marker_24)
                .into(imgCategory);

        return convertView;
    }
}