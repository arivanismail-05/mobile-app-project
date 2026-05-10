package com.example.geovault;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.geovault.Base.BaseActivity;
import com.example.geovault.Base.PlaceModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;

public class DetailActivity extends BaseActivity {

    MaterialToolbar toolbar;
    ImageView imgStaticMap, imgCategory;
    TextView tvDetailTitle, tvDetailCategory, tvDetailLocationName, tvDetailNotes;
    MaterialSwitch switchVisited;
    MaterialButton btnDeletePlace;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        imgStaticMap = findViewById(R.id.imgStaticMap);
        imgCategory = findViewById(R.id.imgCategory);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailCategory = findViewById(R.id.tvDetailCategory);
        tvDetailLocationName = findViewById(R.id.tvDetailLocationName);
        tvDetailNotes = findViewById(R.id.tvDetailNotes);
        switchVisited = findViewById(R.id.switchVisited);
        btnDeletePlace = findViewById(R.id.btnDeletePlace);

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

        index = getIntent().getIntExtra("place_index", -1);

        if (index != -1) {
            PlaceModel place = placesList.get(index);

            tvDetailTitle.setText(place.getTitle());
            tvDetailCategory.setText(place.getCategory());
            tvDetailLocationName.setText(place.getLocation());
            tvDetailNotes.setText(place.getNote());
            switchVisited.setChecked(place.isVisited());

            Glide.with(this)
                    .load(place.getImageUrl())
                    .placeholder(R.drawable.marker_24)
                    .error(R.drawable.marker_24)
                    .into(imgCategory);
            switchVisited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    place.setVisited(isChecked);
                    Toast.makeText(DetailActivity.this, "Status updated!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnDeletePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index != -1) {
                    placesList.remove(index);
                    Toast.makeText(DetailActivity.this, "Deleted successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Glide.with(this).load("https://lh3.googleusercontent.com/VKEIvvokZHFk7Sw1pNk9VChgkXzN_Jz8oYr5JHIK4qeHZtCDwDUuy_qh6O4S3Qb2oyGe6kBSvmOw5xlDguenjeENosM8TTfDUsZvIeY=w609").into(imgStaticMap);
    }
}