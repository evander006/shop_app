package com.example.amazonstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val itemsList=findViewById<RecyclerView>(R.id.itemsList)
        val list = arrayListOf<Item>()
        list.add(Item(1,"mac", "Apple Macbook Pro 16", "The MacBook is a brand of Mac notebook computers designed and marketed by Apple Inc. that use Apple's macOS operating system since 2006.","It replaced the PowerBook and iBook brands during the Mac transition to Intel processors, announced in 2005. The current lineup consists of the MacBook Air (2008–present) and the MacBook Pro (2006–present).", 3499))
        list.add(Item(2,"iphone", "Apple Iphone 16 Pro Max", "The iPhone 15 Pro Max display has rounded corners that follow a beautiful curved design, and these corners are within a standard rectangle. ","When measured as a standard rectangular shape, the screen is 6.69 inches diagonally (actual viewable area is less)", 1299))
        list.add(Item(3,"imac", "Apple IMac Pro", "The iMac Pro is an all-in-one personal computer and workstation made by Apple Inc.","While it was sold, it was one of four desktop computers in the Macintosh lineup, sitting above the consumer range Mac Mini and iMac, and serving as an all-in-one alternative to the Mac Pro.", 9100))
        list.add(Item(4,"watch", "Apple Series 9", "The Apple Watch Series 9","While it was sold, it was one of four desktop computers in the Macintosh lineup, sitting above the consumer range Mac Mini and iMac, and serving as an all-in-one alternative to the Mac Pro.", 900))

        itemsList.layoutManager=LinearLayoutManager(this)//расстанавливает элементы друг под другом
        itemsList.adapter = Adapter(list, this)
    }
}