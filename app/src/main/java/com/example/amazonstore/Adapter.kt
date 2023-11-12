package com.example.amazonstore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class Adapter(var items:List<Item>, var context:Context): RecyclerView.Adapter<Adapter.myViewHolder>() {
    class myViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.image_list)
        val title = view.findViewById<TextView>(R.id.item_list_title)
        val descShort = view.findViewById<TextView>(R.id.item_list_shortDesc)
        val descLong=view.findViewById<TextView>(R.id.item_list_longDesc)
        val price = view.findViewById<TextView>(R.id.item_list_price)
        val button=view.findViewById<Button>(R.id.item_list_button)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)  //находит нужный дизайн
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.title.text=items[position].name
        holder.descShort.text=items[position].descShort
        holder.price.text=items[position].price.toString()+"$"
        val imageid=context.resources.getIdentifier(items[position].image, "drawable", context.packageName)
        holder.image.setImageResource(imageid)
        holder.button.setOnClickListener {
            val intent = Intent(context, ItemActivity::class.java)
            intent.putExtra("ItemImage", imageid)
            intent.putExtra("ItemTitle", items[position].name)
            intent.putExtra("ItemDescLong", items[position].descLong)
            intent.putExtra("ItemPrice", items[position].price.toString()+"$")
            context.startActivity(intent)
        }
    }
}