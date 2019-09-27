package com.nimtego.armaplc.presentation.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.model.Station

class StationsListAdapter(
    private val station: List<Station>,
    private val onClick: (Station) -> Unit
) : RecyclerView.Adapter<StationsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_station, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener { _: View ->
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                this.station[adapterPosition].let {
                    this.onClick(it)
                }
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val station = station[position]
        holder.apply {
            stationName.text = station.nameStation
            stationAddress.text = station.address
            stationPhoneNumber.text = station.phoneNumber
            pollActiveRb.isChecked = station.isPollActive
        }

    }

    override fun getItemCount(): Int = station.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var stationName: TextView = itemView.findViewById(R.id.station_name)
        var stationAddress: TextView = itemView.findViewById(R.id.station_address)
        var stationPhoneNumber: TextView = itemView.findViewById(R.id.station_phone_number)
        var pollActiveRb: CheckBox = itemView.findViewById(R.id.poll_active_rb)
    }
}