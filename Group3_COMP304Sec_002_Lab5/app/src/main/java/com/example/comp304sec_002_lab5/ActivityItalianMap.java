package com.example.comp304sec_002_lab5;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityItalianMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_map);

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
        LatLng sahebi = new LatLng(43.781113,-79.205983);
        LatLng rosa = new LatLng(43.782261,-79.172356);
        LatLng scadda = new LatLng(43.777619,-79.2542854);

        switch (selected){
            case 0: {
                mMap.addMarker(new MarkerOptions().position(home).title("Centennial College")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                mMap.addMarker(new MarkerOptions().position(sahebi).title("Sahebi Italian Food").snippet("2863 Ellesmere Rd"));
                mMap.addMarker(new MarkerOptions().position(rosa).title("Rosa's Pasta Express").snippet("271 Old Kingston Rd"));
                mMap.addMarker(new MarkerOptions().position(scadda).title("Scaddabush").snippet("580 Progress Ave"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 12));
                break;
            }
            case 1: {
                mMap.addMarker(new MarkerOptions().position(sahebi).title("Sahebi Italian Food").snippet("2863 Ellesmere Rd"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sahebi, 15));
                break;
            }
            case 2: {
                mMap.addMarker(new MarkerOptions().position(rosa).title("Rosa's Pasta Express").snippet("271 Old Kingston Rd"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rosa, 15));
                break;
            }
            case 3: {
                mMap.addMarker(new MarkerOptions().position(scadda).title("Scaddabush").snippet("580 Progress Ave"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(scadda, 15));
                break;
            }
        }
    }
}