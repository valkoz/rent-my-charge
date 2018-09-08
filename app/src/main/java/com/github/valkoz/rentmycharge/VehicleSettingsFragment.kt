package com.github.valkoz.rentmycharge

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

//TODO hardcode view, hardcode Map, hardcode everything
class VehicleSettingsFragment : Fragment() {

    companion object {
        fun newInstance(): VehicleSettingsFragment {
            return VehicleSettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_vehicle_settings, container, false)

        val button : Button = view.findViewById(R.id.find_charge)

        val intent = Intent(activity, MainActivity::class.java)

        button.setOnClickListener {
            startActivity(intent)
        }

        return view
    }
}
