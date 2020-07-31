package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_card.view.*

class SimpleAdapter(private val nemployee: List<Employee>): RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>(){
    class SimpleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.image
        val mainTextView: TextView = itemView.mainText
        val textView: TextView = itemView.text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val itemView = inflater.inflate(R.layout.simple_card, parent, false)
        // Return a new holder instance
        return SimpleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return nemployee.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val item =  nemployee[position]
        holder.imageView.setImageResource(item.Image)
        holder.mainTextView.text = item.mainText
        holder.textView.text = item.text
    }
}