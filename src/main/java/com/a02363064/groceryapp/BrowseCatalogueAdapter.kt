package com.a02363064.groceryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.groceryapp.databinding.BrowseListItemBinding

class BrowseCatalogueAdapter(val browsing: List<FoodItems>): RecyclerView.Adapter<BrowseCatalogueAdapter.ViewHolder>() {
    class ViewHolder(val binding: BrowseListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = browsing[position]
        holder.binding.BrowseListItemName.text = item.name
        holder.binding.browseListAisle.text = item.location
        holder.binding.browseListCost.text = item.cost
    }

    override fun getItemCount(): Int {
        return browsing.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrowseListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}