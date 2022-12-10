package com.a02363064.groceryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.groceryapp.databinding.SelectListListItemBinding

data class ShoppingLists(
    val name: String
)

class SelectListAdapter(val lists: List<ShoppingLists>): RecyclerView.Adapter<SelectListAdapter.ViewHolder>() {
    class ViewHolder(val binding:SelectListListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = lists[position]
        holder.binding.ItemListName.text = list.name
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SelectListListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}