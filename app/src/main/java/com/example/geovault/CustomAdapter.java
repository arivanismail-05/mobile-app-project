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

public class CustomAdapter extends BaseAdapter {

    ArrayList<PlaceModel> places;
    Activity context;

    public CustomAdapter(ArrayList<PlaceModel> places, Activity context) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.single_item, viewGroup, false);
        }

        ImageView imgCategory = view.findViewById(R.id.imgCategory);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvCategory = view.findViewById(R.id.tvCategory);
        TextView tvTime = view.findViewById(R.id.tvTime);

        PlaceModel place = places.get(i);

        tvTitle.setText(place.getTitle());
        tvCategory.setText(place.getCategory());
        tvTime.setText(place.getLocation());

        Glide.with(context)
                .load(place.getImageUrl())
                .into(imgCategory);

        return view;
    }
}