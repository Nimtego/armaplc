package com.nimtego.armaplc.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.view_model.StationViewModel

class StationsListAdapter(
    val stationModel: List<StationViewModel>,
    private val onClick: (StationViewModel) -> Unit
) : RecyclerView.Adapter<StationsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_station, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener { _: View ->
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                this.stationModel.get(adapterPosition).let {
                    this.onClick(it)
                }
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.stationName.text = this.stationModel[position].nameStation
    }

    override fun getItemCount(): Int = stationModel.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var stationName: TextView = itemView.findViewById(R.id.station_name_text_view)
    }
}