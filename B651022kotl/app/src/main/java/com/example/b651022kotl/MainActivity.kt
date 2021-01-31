package com.example.b651022kotl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = generateDummyList(50)

        recyclerView = findViewById(R.id.recycle_view)
        recyclerView?.adapter = LittleAdapter(items)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)



    }

    private fun generateDummyList(size: Int): List<LittleItem>{
        val items = ArrayList<LittleItem>()

        for(i in 0 until size){
            val image = when(i % 3){
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = LittleItem(image, "Item $i", "Line 2")
            items += item
        }
        return items
    }

}