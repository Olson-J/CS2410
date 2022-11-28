package com.a02363064.webbrowser

import java.util.LinkedList

class History {
    // doubly linked list for history here
    private var history = LinkedList<String>()
    private var place = -1

    fun add(newString: String){
        history.addLast(newString)
        place = history.size - 1
    }

    fun back(): String {
        // if available, move back to last website
        if (place > 0) {
            place--
        }
        return history[place]
    }

    fun forward(): String {
        // if available, move back to last website
        if (place < (history.size - 1)) {
            place++
        }
        return history[place]
    }
}