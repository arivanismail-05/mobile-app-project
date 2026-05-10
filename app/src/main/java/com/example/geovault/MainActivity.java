package com.example.geovault;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import com.example.geovault.Base.BaseActivity;
import com.example.geovault.Base.PlaceModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    MaterialButton btnAdd, btnVisited;
    ChipGroup mainCategoryChipGroup;
    TextInputEditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnVisited = findViewById(R.id.btnVisited);
        mainCategoryChipGroup = findViewById(R.id.mainCategoryChipGroup);
        searchEditText = findViewById(R.id.searchEditText);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

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
                redirect(MapActivity.class);
            }
        });


        btnVisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect(VisitedActivity.class);
            }
        });


    }

    private void filter(String text) {
        ArrayList<PlaceModel> filteredList = new ArrayList<>();

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_fragment_container);

        for (PlaceModel item : placesList) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {

                if (currentFragment instanceof AllFragment) {
                    filteredList.add(item);
                } else if (currentFragment instanceof HomeFragment && item.getCategory().equalsIgnoreCase("Home")) {
                    filteredList.add(item);
                } else if (currentFragment instanceof WorkFragment && item.getCategory().equalsIgnoreCase("Work")) {
                    filteredList.add(item);
                }
            }
        }

        if (currentFragment instanceof AllFragment) {
            ((AllFragment) currentFragment).updateAdapter(filteredList);
        } else if (currentFragment instanceof HomeFragment) {
            ((HomeFragment) currentFragment).updateAdapter(filteredList);
        } else if (currentFragment instanceof WorkFragment) {
            ((WorkFragment) currentFragment).updateAdapter(filteredList);
        }
    }

    private void replaceFragment(androidx.fragment.app.Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit();
    }

    protected void onResume() {
        super.onResume();
        mainCategoryChipGroup.check(R.id.chipAll);
        replaceFragment(new AllFragment());
    }
}