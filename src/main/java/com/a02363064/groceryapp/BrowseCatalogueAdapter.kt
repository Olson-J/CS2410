package com.a02363064.groceryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.groceryapp.databinding.BrowseListItemBinding
import com.a02363064.groceryapp.models.Item

class BrowseCatalogueAdapter(val items: ObservableArrayList<Item>,
                             val onAddItemClicked: (Item) -> Unit): RecyclerView.Adapter<BrowseCatalogueAdapter.ViewHolder>() {
    class ViewHolder(val binding: BrowseListItemBinding): RecyclerView.ViewHolder(binding.root)

    init {
        items.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<Item>>() {
            override fun onChanged(sender: ObservableArrayList<Item>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                sender: ObservableArrayList<Item>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemChanged(positionStart)
            }

            override fun onItemRangeInserted(
                sender: ObservableArrayList<Item>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemInserted(positionStart)
            }

            override fun onItemRangeMoved(
                sender: ObservableArrayList<Item>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {

            }

            override fun onItemRangeRemoved(
                sender: ObservableArrayList<Item>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemRemoved(positionStart)
            }
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
//        holder.binding.browseItemName.isChecked = item.onList
        holder.binding.browseItemName.text = item.name
        holder.binding.browseListAisle.text = item.location
        holder.binding.browseListCost.text = item.cost
        holder.binding.browseItemName.setOnClickListener{
            onAddItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrowseListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}