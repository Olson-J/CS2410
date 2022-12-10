package com.a02363064.groceryapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
        @PrimaryKey(autoGenerate = true) var id: Long,
        @ColumnInfo var name: String,
        @ColumnInfo var location: String,
        @ColumnInfo var cost: String,
        @ColumnInfo var onList: Boolean
)
