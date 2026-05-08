package com.example.geovault;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.geovault.Base.BaseActivity;

public class AllFragment extends Fragment {

    public ListView lvAllPlaces;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        lvAllPlaces = view.findViewById(R.id.lvAllPlaces);

        updateList();

        lvAllPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);

                intent.putExtra("place_index", position);

                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
        if (lvAllPlaces != null && BaseActivity.placesList != null) {
            CustomAdapter adapter = new CustomAdapter(BaseActivity.placesList, getActivity());
            lvAllPlaces.setAdapter(adapter);
        }
    }
}