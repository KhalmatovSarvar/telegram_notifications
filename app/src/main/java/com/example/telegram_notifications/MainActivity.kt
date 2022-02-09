package com.example.telegram_notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram_notifications.adapter.NotificationAdapter
import com.example.telegram_notifications.model.Item

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        refreshAdapter(getItems())
    }

    private fun refreshAdapter(items: ArrayList<Item>) {
        val adapter = NotificationAdapter(this,items)
        recyclerView.adapter = adapter

    }

    private fun getItems(): ArrayList<Item> {
        var items: ArrayList<Item> = ArrayList()

        for (i in 0..10){
            items.add(Item("NOtification $i"))
        }
            return items
    }
}