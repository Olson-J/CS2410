package com.a02363064.groceryapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.a02363064.groceryapp.models.Item

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getListDao(): ListDao
}