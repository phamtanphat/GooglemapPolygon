package com.example.googlemapdc_solar

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.bkhezry.mapdrawingtools.model.DataModel
import com.github.bkhezry.mapdrawingtools.model.DrawingOption
import com.github.bkhezry.mapdrawingtools.model.DrawingOptionBuilder
import com.github.bkhezry.mapdrawingtools.ui.MapsActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class DrawlineActivity : AppCompatActivity() , OnMapReadyCallback {
    override fun onMapReady(p0: GoogleMap?) {

    }

    val REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawline)
        var supportMapsActivity : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.google_map) as SupportMapFragment
        supportMapsActivity.getMapAsync(this)
//        val currentDrawingType = DrawingOption.DrawingType.POLYGON
//
//        val intent = DrawingOptionBuilder()
//            .withCalculateLayoutHidden()
//            .withSatelliteViewHidden()
//            .withLocation(40.758347, -73.970185)
//            .withMapZoom(14f)
//            .withFillColor(Color.rgb(231, 188, 81))
//            .withStrokeColor(Color.rgb(231, 188, 81))
//            .withStrokeWidth(3)
//            .withRequestGPSEnabling(false)
//            .withDrawingType(currentDrawingType)
//            .build(applicationContext)
//        startActivityForResult(intent, REQUEST_CODE)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null) {
//            val dataModel = data.extras!!.getParcelable<DataModel>(MapsActivity.POINTS)
//            val points = dataModel!!.points
//            Log.d("BBB",points[0].toString())
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

}
