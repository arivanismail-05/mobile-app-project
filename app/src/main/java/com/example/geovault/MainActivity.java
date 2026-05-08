package com.example.geovault;

import android.os.Bundle;
import android.view.View;
import com.example.geovault.Base.BaseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

public class MainActivity extends BaseActivity {

    MaterialButton btnAdd, btnMap, btnVisited;
    ChipGroup mainCategoryChipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnMap = findViewById(R.id.btnMap);
        btnVisited = findViewById(R.id.btnVisited);
        mainCategoryChipGroup = findViewById(R.id.mainCategoryChipGroup);

        mainCategoryChipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, List<Integer> checkedIds) {
                if (checkedIds.isEmpty()) return;

                int checkedId = checkedIds.get(0);
                if (checkedId == R.id.chipAll) {
                    replaceFragment(new AllFragment());
                } else if (checkedId == R.id.chipHome) {
                    replaceFragment(new HomeFragment());
                } else if (checkedId == R.id.chipWork) {
                    replaceFragment(new WorkFragment());
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect(AddActivity.class);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect(MapActivity.class);
            }
        });

        btnVisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect(VisitedActivity.class);
            }
        });

        if (savedInstanceState == null) {
            replaceFragment(new AllFragment());
        }
    }

    private void replaceFragment(androidx.fragment.app.Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }
}