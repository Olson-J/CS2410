package com.a02363064.groceryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.groceryapp.databinding.MyListListItemBinding


class MyListAdapter(val items: List<FoodItems>): RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
    class ViewHolder(val binding: MyListListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.MyListItemName.text = item.name
        holder.binding.itemListAisle.text = item.location
        holder.binding.itemListCost.text = item.cost
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyListListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}