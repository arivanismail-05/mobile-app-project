package com.example.geovault;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.overlay.MapEventsOverlay;

import com.example.geovault.Base.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class MapActivity extends BaseActivity {
    MaterialToolbar toolbar;
    MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences myPrefs = getSharedPreferences("MyMapPrefs", MODE_PRIVATE);

        Configuration.getInstance().load(this, myPrefs);

        setContentView(R.layout.activity_map);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        map = findViewById(R.id.mapview);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(15.0);
        GeoPoint startPoint = new GeoPoint(36.1901, 44.0091);
        mapController.setCenter(startPoint);

        map.getOverlays().add(new MapEventsOverlay(new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                String locationData = p.getLatitude() + ", " + p.getLongitude();
                Intent intent = new Intent(MapActivity.this, AddActivity.class);
                intent.putExtra("selected_location", locationData);
                startActivity(intent);
                finish();
                return true;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                return false;
            }
        }));
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }
}