package com.example.googlemapdc_solar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.*
import kotlinx.android.synthetic.main.activity_bando.*


class BandoActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bando)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(40.758347, -73.970185)
        mMap.addMarker(MarkerOptions().position(sydney).title("Lexington Avenue"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18.0f))
        mMap.uiSettings.isZoomGesturesEnabled = true
        buttonCapture.setOnClickListener { view ->
            val snapshotReadyCallback = GoogleMap.SnapshotReadyCallback { bitmap ->
                imageviewHinh.setImageBitmap(bitmap)
            }
            mMap.snapshot(snapshotReadyCallback)
        }
    }
}
