package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items : List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder> (){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemTextView: TextView
        var priceTextView: TextView
        var sourceTextView: TextView

        init {
            // the public final member variables created above
            itemTextView = itemView.findViewById(R.id.itemTV)
            priceTextView = itemView.findViewById(R.id.priceTV)
            sourceTextView = itemView.findViewById(R.id.sourceTV)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = item.itemName
        holder.priceTextView.text = item.itemPrice
        holder.sourceTextView.text = item.itemSource

    }

    override fun getItemCount(): Int {
        return items.size
    }
}