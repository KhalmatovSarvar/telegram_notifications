package com.example.telegram_notifications.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.telegram_notifications.R
import com.example.telegram_notifications.model.Item

class NotificationAdapter(var context: Context,var items: ArrayList<Item>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var TYPE_FIRST_ITEM = 0
    private var TYPE_SECOND_ITEM = 1
    private var TYPE_THIRD_ITEM = 2

    override fun getItemViewType(position: Int): Int {
        if(position == 0) return TYPE_FIRST_ITEM
        if(position == 1) return TYPE_SECOND_ITEM
        return TYPE_THIRD_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_FIRST_ITEM){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_first,parent,false)
            return FirstItemViewHolder(view)
        }else if(viewType == TYPE_SECOND_ITEM){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_second,parent,false)
            return SecondItemViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_third,parent,false)
            return ThirdItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]

        if (holder is FirstItemViewHolder){ }
        if (holder is SecondItemViewHolder){ }
        if (holder is ThirdItemViewHolder){
            var tv_headline = holder.tv_headline

            tv_headline.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class FirstItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
class SecondItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}
class ThirdItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_headline :TextView
        init {
            tv_headline = view.findViewById(R.id.tv_headline_theme)
        }
}
