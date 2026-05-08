package com.example.geovault;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.geovault.Base.BaseActivity;
import com.example.geovault.Base.PlaceModel;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class VisitedActivity extends BaseActivity {
    MaterialToolbar toolbar;
    ListView mainListView;
    ArrayList<PlaceModel> visitedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited);

        toolbar = findViewById(R.id.toolbar);
        mainListView = findViewById(R.id.mainListView);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        updateVisitedList();

        // ئەگەر ویستت لە لاپەڕەی Visited-یشەوە بچیتە ناو Detail
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaceModel selectedPlace = visitedList.get(position);
                int realIndex = placesList.indexOf(selectedPlace);

                Intent intent = new Intent(VisitedActivity.this, DetailActivity.class);
                intent.putExtra("place_index", realIndex);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateVisitedList(); // بۆ ئەوەی ئەگەر لە Detail گۆڕانکاریت کرد، لێرە یەکسەر نوێ بێتەوە
    }

    private void updateVisitedList() {
        visitedList = new ArrayList<>();

        // مەرجەکە لێرەیە: تەنها ئەو شوێنانەی Visited کراون
        for (PlaceModel p : placesList) {
            if (p.isVisited()) {
                visitedList.add(p);
            }
        }

        CustomAdapterVisited adapter = new CustomAdapterVisited(visitedList, this);
        mainListView.setAdapter(adapter);
    }
}