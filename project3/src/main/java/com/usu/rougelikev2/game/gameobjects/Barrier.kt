package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location

class Barrier(game: Game) : GameObject(game) {
    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space
        val coords: Location = state["coords"]
        val cellSize: Int = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize
        canvas.translate(myX, myY)
        paint.color = Color.DKGRAY
        canvas.drawRect(0f, 0f, cellSize.toFloat(), cellSize.toFloat(), paint)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        paint.color = Color.BLACK
        canvas.drawRect(0f, 0f, cellSize.toFloat(), cellSize.toFloat(), paint)
        paint.strokeWidth = 3f
        canvas.drawRect(0f, 0f, cellSize.toFloat() / 2,
            cellSize.toFloat() / 2, paint)
        canvas.drawRect(cellSize.toFloat() / 2, cellSize.toFloat() / 2, cellSize.toFloat(),
            cellSize.toFloat(), paint)
        canvas.drawRect(cellSize.toFloat() / 4, cellSize.toFloat() / 4, cellSize.toFloat(),
            cellSize.toFloat(), paint)
        canvas.drawRect(3 * (cellSize.toFloat() / 4), 3 * (cellSize.toFloat() / 4),
            cellSize.toFloat(), cellSize.toFloat(), paint)
    }
}