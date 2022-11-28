package com.usu.rougelikev2.game.gameobjects


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location


class Door(game: Game?) : GameObject(game!!) {
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
        paint.color = Color.argb(165, 165,94,0)
        canvas.drawRect(10f, 10f, (cellSize - 10).toFloat(), (cellSize - 10).toFloat(), paint)

        paint.color = Color.YELLOW
        canvas.drawRect(120f, 80f, (cellSize - 15).toFloat(), (cellSize - 50).toFloat(), paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f
        paint.color = Color.argb(230, 33,1,0)
        canvas.drawRect(20f, 20f, (cellSize - 95).toFloat(), (cellSize - 20).toFloat(), paint)
        canvas.drawRect(20f, 80f, (cellSize - 95).toFloat(), (cellSize - 20).toFloat(), paint)
        canvas.drawRect(75f, 20f, (cellSize - 40).toFloat(), (cellSize - 20).toFloat(), paint)
        canvas.drawRect(75f, 80f, (cellSize - 40).toFloat(), (cellSize - 20).toFloat(), paint)
        canvas.drawRect(10f, 10f, (cellSize - 10).toFloat(), (cellSize - 10).toFloat(), paint)
        canvas.drawRect(120f, 80f, (cellSize - 15).toFloat(), (cellSize - 50).toFloat(), paint)
    }
}