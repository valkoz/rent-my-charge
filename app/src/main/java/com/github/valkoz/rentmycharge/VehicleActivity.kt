package com.github.valkoz.rentmycharge

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class VehicleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_content, VehicleListFragment.newInstance(), "VehicleListFragment")
                .commit()

    }
}
