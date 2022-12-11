package com.a02363064.groceryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.a02363064.groceryapp.databinding.BrowseListItemBinding
import com.a02363064.groceryapp.databinding.SelectListListItemBinding
import com.a02363064.groceryapp.models.Item

data class ShoppingLists(
    val name: String
)
//lists: List<ShoppingLists>
class SelectListAdapter(val items: ObservableArrayList<Item>, val onAddItemClicked: (Item) -> Unit): RecyclerView.Adapter<SelectListAdapter.ViewHolder>() {
    class ViewHolder(val binding:SelectListListItemBinding): RecyclerView.ViewHolder(binding.root)

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
        holder.binding.myListItemName.text = item.name
        holder.binding.selectItemAisle.text = item.location
        holder.binding.selectItemCost.text = item.cost
        if (item.onList) {
            onAddItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SelectListListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}