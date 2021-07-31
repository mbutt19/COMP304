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

public class ActivityGreekMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_map);
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
        LatLng jimmy = new LatLng(43.7761341,-79.2584376);
        LatLng osmow = new LatLng(43.790208,-79.195431);
        LatLng mr = new LatLng(43.8002689,-79.19772);

        switch (selected){
            case 0: {
                mMap.addMarker(new MarkerOptions().position(home).title("Centennial College")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                mMap.addMarker(new MarkerOptions().position(osmow).title("Osmow's").snippet("790 Military Trail"));
                mMap.addMarker(new MarkerOptions().position(jimmy).title("Jimmy The Greek").snippet("300 Borough Dr"));
                mMap.addMarker(new MarkerOptions().position(mr).title("Mr Greek").snippet("855 Milner Ave"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 12));
                break;
            }
            case 1: {
                mMap.addMarker(new MarkerOptions().position(osmow).title("Osmow's").snippet("790 Military Trail"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(osmow, 15));
                break;
            }
            case 2: {
                mMap.addMarker(new MarkerOptions().position(jimmy).title("Jimmy The Greek").snippet("300 Borough Dr"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jimmy, 15));
                break;
            }
            case 3: {
                mMap.addMarker(new MarkerOptions().position(mr).title("Mr Greek").snippet("855 Milner Ave"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mr, 15));
                break;
            }
        }
    }
}