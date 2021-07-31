package com.example.comp304sec_002_lab5;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityChineseMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btn = (Button) findViewById(R.id.switchMap);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
                else if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE){
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
                else if(mMap.getMapType() == GoogleMap.MAP_TYPE_HYBRID){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        selected = getIntent().getIntExtra(getString(R.string.intentName),0);

        // Add marker latlongs
        LatLng home = new LatLng(43.7863311,-79.2264328);
        LatLng asian = new LatLng(43.794498,-79.23569);
        LatLng chopstick = new LatLng(43.851217,-79.254376);
        LatLng tim = new LatLng(43.7454399,-79.2200516);

        switch (selected){
            case 0: {
                mMap.addMarker(new MarkerOptions().position(home).title("Centennial College")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                mMap.addMarker(new MarkerOptions().position(asian).title("Asian Legend").snippet("4452 Sheppard Ave E"));
                mMap.addMarker(new MarkerOptions().position(chopstick).title("Chopstick House").snippet("1780 Markham Rd"));
                mMap.addMarker(new MarkerOptions().position(tim).title("Tim Choi").snippet("266 Markham Rd"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 12));
                break;
            }
            case 1: {
                mMap.addMarker(new MarkerOptions().position(asian).title("Asian Legend").snippet("4452 Sheppard Ave E"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(asian, 15));
                break;
            }
            case 2: {
                mMap.addMarker(new MarkerOptions().position(chopstick).title("Chopstick House").snippet("1780 Markham Rd"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chopstick, 15));
                break;
            }
            case 3: {
                mMap.addMarker(new MarkerOptions().position(tim).title("Tim Choi").snippet("266 Markham Rd"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tim, 15));
                break;
            }
        }
    }
}