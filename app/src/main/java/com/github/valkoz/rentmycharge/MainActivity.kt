package com.github.valkoz.rentmycharge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import android.widget.LinearLayout




class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private var llBottomSheet : LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBottomSheet = findViewById<View>(R.id.bottom_sheet) as LinearLayout
        val bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet)
        //bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        //bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        main_map_view.onCreate(Bundle())
        main_map_view.getMapAsync(this)

    }

    override fun onResume() {
        super.onResume()
        main_map_view.onResume()
    }

    override fun onStart() {
        super.onStart()
        main_map_view.onStart()
    }

    override fun onStop() {
        super.onStop()
        main_map_view.onStop()
    }

    override fun onPause() {
        main_map_view.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        main_map_view.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        main_map_view.onLowMemory()
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map!!
        googleMap?.setMinZoomPreference(12F)
        val ny = LatLng(40.7143528, -74.0059731)
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(ny))

        val markerOptions = MarkerOptions()
                .position(LatLng(40.7143528, -74.0059731))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
        val marker = googleMap?.addMarker(markerOptions)
        marker?.hideInfoWindow()

        googleMap?.setOnMarkerClickListener {
            val bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            true
        }

    }


}
