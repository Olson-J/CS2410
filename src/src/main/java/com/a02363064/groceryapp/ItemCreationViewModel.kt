package com.a02363064.groceryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a02363064.groceryapp.models.Item
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItemCreationViewModel : ViewModel() {
    val errorMessage = MutableLiveData("")
    val done = MutableLiveData(false)

    fun createItem(itemName: String, itemAisle: String, itemCost: String) {
        errorMessage.value = ""
        if (itemName.isEmpty() or itemAisle.isEmpty() or itemCost.isEmpty()) {
            errorMessage.value = "Item inputs cannot be blank."
            viewModelScope.launch {
                delay(3000)
                errorMessage.value = ""
            }
            return
        }
        if(itemName.trim().isEmpty() or itemAisle.trim().isEmpty() or itemCost.trim().isEmpty()) {
            errorMessage.value = "Item inputs must contain at least one alpha numerica character"
            return
        }

        // create todo
        viewModelScope.launch {
            val item = Item(id = 0, name = itemName, location = itemAisle, cost = itemCost, true)
            ItemRepository.createItem(item);
            done.value = true
        }

    }
}