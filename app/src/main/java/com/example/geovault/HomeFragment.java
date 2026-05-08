package com.example.geovault;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.geovault.Base.BaseActivity;
import com.example.geovault.Base.PlaceModel;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView lvHomePlaces;
    ArrayList<PlaceModel> homeList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lvHomePlaces = view.findViewById(R.id.lvHomePlaces);

        updateHomeList();

        lvHomePlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // دۆزینەوەی ئیندێکسی ڕاستەقینە لە ناو placesList
                PlaceModel selectedPlace = homeList.get(position);
                int realIndex = BaseActivity.placesList.indexOf(selectedPlace);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("place_index", realIndex);
                startActivity(intent);
            }
        });

        return view;
    }

    private void updateHomeList() {
        homeList = new ArrayList<>();
        for (PlaceModel p : BaseActivity.placesList) {
            if (p.getCategory().equalsIgnoreCase("Home")) {
                homeList.add(p);
            }
        }
        CustomAdapter adapter = new CustomAdapter(homeList, (Activity) getActivity());
        lvHomePlaces.setAdapter(adapter);
    }
}