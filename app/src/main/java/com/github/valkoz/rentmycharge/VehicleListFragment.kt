package com.github.valkoz.rentmycharge


import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.valkoz.rentmycharge.model.Vehicle


class VehicleListFragment : Fragment() {

    companion object {
        fun newInstance(): VehicleListFragment {
            return VehicleListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_vehicle_list, container,
                false)
        val activity = activity
        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val v1: Vehicle = Vehicle("BMW 330e", "2 editions", BitmapFactory.decodeResource(this.resources, R.drawable.stub_e330))
        val v2: Vehicle = Vehicle("Azure Dynamics Transit Connect", "28kWh", BitmapFactory.decodeResource(this.resources, R.drawable.stub_azure))
        val v3: Vehicle = Vehicle("Audi Q7 e-tron", "12 kWh", BitmapFactory.decodeResource(this.resources, R.drawable.stub_audi))
        val v4: Vehicle = Vehicle("BMW C evolution", "2 editions", BitmapFactory.decodeResource(this.resources, R.drawable.stub_bmw_c))
        val v5: Vehicle = Vehicle("Brammo Empulse", "10.2kWh", BitmapFactory.decodeResource(this.resources, R.drawable.stub_brammo))
        val v6: Vehicle = Vehicle("Twike 3", "14 kWh", BitmapFactory.decodeResource(this.resources, R.drawable.stub_twike))

        val vehicles: List<Vehicle> = listOf(v1, v2, v3, v4, v5, v6)

        recyclerView.adapter = ItemVehicleAdapter(vehicles) {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragment_content, VehicleSettingsFragment.newInstance(), "VehicleSettingsFragment")
                    ?.addToBackStack(null)
                    ?.commit()
        }
        return view
    }

}
