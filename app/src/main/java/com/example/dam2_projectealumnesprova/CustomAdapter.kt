package com.example.dam2_projectealumnesprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val mList: List<AlumnesViewModel>,
    private val itemClickListener: (AlumnesViewModel) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.textViewNom.text = item.nom
        holder.textViewEdat.text = item.edat
        holder.textViewCurs.text = item.curs.toString()

        holder.itemView.setOnClickListener {
            itemClickListener(item)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.Nom)
        val textViewEdat: TextView = itemView.findViewById(R.id.Edat)
        val textViewCurs: TextView = itemView.findViewById(R.id.Curs)
    }
}
