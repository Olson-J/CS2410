package com.a02363064.groceryapp

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a02363064.groceryapp.models.Item
import kotlinx.coroutines.*

var idCounter = 0

class ItemViewModel: ViewModel() {
    val items = ObservableArrayList<Item>()
    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            val loadedItems = ItemRepository.getAllItems()
            items.addAll(loadedItems)
        }
    }

    fun toggleItemClicked(item: Item) {
        viewModelScope.launch {
            val itemCopy = item.copy(onList = !item.onList)
//            item.onList = !item.onList
            ItemRepository.update(itemCopy)
            items[items.indexOf(item)] = item.copy()
        }
    }
}