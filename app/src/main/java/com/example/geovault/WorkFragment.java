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

public class WorkFragment extends Fragment {

    ListView lvWorkPlaces;
    ArrayList<PlaceModel> workList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        lvWorkPlaces = view.findViewById(R.id.lvWorkPlaces);

        updateWorkList();

        lvWorkPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaceModel selectedPlace = workList.get(position);
                int realIndex = BaseActivity.placesList.indexOf(selectedPlace);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("place_index", realIndex);
                startActivity(intent);
            }
        });

        return view;
    }

    private void updateWorkList() {
        workList = new ArrayList<>();
        for (PlaceModel p : BaseActivity.placesList) {
            if (p.getCategory().equalsIgnoreCase("Work")) {
                workList.add(p);
            }
        }
        CustomAdapter adapter = new CustomAdapter(workList, (Activity) getActivity());
        lvWorkPlaces.setAdapter(adapter);
    }
}