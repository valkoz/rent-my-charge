package com.github.valkoz.rentmycharge

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.valkoz.rentmycharge.model.Vehicle
import kotlinx.android.synthetic.main.item_vehicle.view.*

class ItemVehicleAdapter(private var dataset : List<Vehicle>, private val listener: (Int) -> Unit)
    : RecyclerView.Adapter<ItemVehicleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Vehicle, pos: Int, listener: (Int) -> Unit) = with(itemView) {
            title.text = item.name
            props.text = item.props
            car_image.setImageBitmap(item.image)
            itemView.setOnClickListener {
                listener(pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVehicleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_vehicle, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position], position, listener)
    }
}