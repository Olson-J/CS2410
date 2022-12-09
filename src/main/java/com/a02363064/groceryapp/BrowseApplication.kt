package com.a02363064.groceryapp

import android.app.Application

class BrowseApplication: Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: Application? = null

        fun getInstance(): Application {
            return instance!!
        }
    }
}