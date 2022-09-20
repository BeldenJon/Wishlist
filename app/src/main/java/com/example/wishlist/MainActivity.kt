package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var items : MutableList<Item> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRV)
        var newItem : EditText = findViewById(R.id.addItemName)
        var newPrice : EditText = findViewById(R.id.addItemPrice)
        var newLink : EditText = findViewById(R.id.addItemLink)

        // Create adapter passing in the list of items
        val adapter = ItemAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.addItemBTN).setOnClickListener{
            var newWishItem = Item(newItem.text.toString(), newPrice.text.toString(), newLink.text.toString())
            items.add(newWishItem)
            adapter.notifyDataSetChanged()
        }
    }
}
