package com.a02363064.groceryapp

import androidx.room.Room
import com.a02363064.groceryapp.models.Item

object ItemRepository {
    private val db: AppDatabase
    init {
        db = Room.databaseBuilder(
            BrowseApplication.getInstance(),
            AppDatabase::class.java,
            "items-database"
        ).build()
    }

    suspend fun createItem(item: Item) {
        db.getListDao().createItem(item)
    }

    suspend fun getAllItems(): List<Item> {
        return listOf()
    }

    suspend fun toggleCompletion(item: Item) {

    }
}