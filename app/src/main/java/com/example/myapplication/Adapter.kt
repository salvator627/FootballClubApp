package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list : ArrayList<Club>): RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    private  var  OnItemClickListener : onItemClickListener? = null

    fun setonItemClickListener(onItemClickListener: onItemClickListener){
        this.OnItemClickListener = onItemClickListener
    }

    inner class AdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(club: Club){
            with(itemView){
                val name = findViewById<TextView>(R.id.tv_name)
                val league = findViewById<TextView>(R.id.tv_desc)
                val image = findViewById<ImageView>(R.id.imageView)
                name.text = club.name
                league.text = club.league
                image.setImageResource(club.image)
                itemView.setOnClickListener {
                    OnItemClickListener?.onItemClicked(club)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.club, parent,false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    interface onItemClickListener{
        fun onItemClicked(data: Club)
    }
}