package com.a02363064.groceryapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.a02363064.groceryapp.models.Item

@Dao
interface ListDao {

    // could say 'select name from' to only get the names
    @Query("SELECT * FROM item")
    suspend fun getAllItems(): List<Item>

    // create one item at a time, return name/ID
    @Insert
    suspend fun createItem(item: Item): Long

//    // create multiple items at a time, pass in as args
//    @Insert
//    suspend fun createMany(vararg items: List<Item>)

    // update an item
    @Update
    suspend fun updateItem(item: Item)
}