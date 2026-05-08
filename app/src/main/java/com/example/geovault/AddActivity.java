package com.example.geovault;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.geovault.Base.BaseActivity;
import com.example.geovault.Base.PlaceModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

public class AddActivity extends BaseActivity {

    MaterialToolbar toolbar;
    TextInputEditText etTitle, etLocation, etNote;
    ChipGroup categoryChipGroup;
    MaterialButton btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.etTitle);
        etLocation = findViewById(R.id.etLocation);
        etNote = findViewById(R.id.etNote);
        categoryChipGroup = findViewById(R.id.categoryChipGroup);
        btnSave = findViewById(R.id.btnSave);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        categoryChipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {
            for (int i = 0; i < group.getChildCount(); i++) {
                Chip chip = (Chip) group.getChildAt(i);
                if (chip.isChecked()) {
                    chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.main_blue)));
                } else {
                    chip.setChipBackgroundColor(ColorStateList.valueOf(getResources().getColor(R.color.card_dark)));
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString().trim();
                String location = etLocation.getText().toString().trim();
                String note = etNote.getText().toString().trim();

                int checkedChipId = categoryChipGroup.getCheckedChipId();
                String category = "";

                if (checkedChipId != View.NO_ID) {
                    Chip chip = findViewById(checkedChipId);
                    String fullText = chip.getText().toString();

                    category = fullText.replaceAll("[^a-zA-Z]", "").trim();
                }

                if (!title.isEmpty() && !location.isEmpty() && !category.isEmpty()) {
                    PlaceModel newPlace = new PlaceModel(title, location, category, note, false);
                    placesList.add(newPlace);

                    Toast.makeText(AddActivity.this, "Added: " + category, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddActivity.this, "Please fill all fields and select a category", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}