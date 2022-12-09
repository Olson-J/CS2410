package com.a02363064.groceryapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
        @PrimaryKey val name: String,
        @ColumnInfo val location: String,
        @ColumnInfo val cost: String,
        @ColumnInfo val onList: String
)
