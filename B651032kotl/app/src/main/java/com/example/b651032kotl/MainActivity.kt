package com.example.b651032kotl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val items = generateDummyList(50)
    private val adapter = LittleAdapter(items)


    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycle_view)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): ArrayList<LittleItem>{
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

    fun onInsert(view: View) {
        val index: Int = Random.nextInt(8)

        val item = LittleItem(
            R.drawable.ic_android,
            "New item at position $index",
            "Line 2"
        )
        items.add(index, item)
        adapter.notifyItemInserted(index)
    }

    fun onRemove(view: View) {
        val index: Int = Random.nextInt(8)
        items.removeAt(index)
        adapter.notifyItemRemoved(index)

    }
}