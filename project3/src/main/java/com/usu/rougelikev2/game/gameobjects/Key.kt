package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location


class  Key(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space
//        val isActive: Boolean = state.get("active") // get whether the key is active or not (not active means the player already picked it up)
        val isActive: Boolean = state["active"]
        if (!isActive) return
        val coords: Location = state["coords"]
        val cellSize: Int = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize

        canvas.translate(myX, myY)
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 4f
        paint.color = Color.YELLOW
        canvas.drawCircle(
            (cellSize / 2).toFloat() + 40,
            (cellSize / 2).toFloat(),
            (cellSize / 2).toFloat() - 50,
            paint
        )
        canvas.drawRect(30f, 70f, 100f, 80f, paint)
        canvas.drawRect(30f, 80f, 40f, 105f, paint)
        canvas.drawRect(50f, 80f, 60f, 105f, paint)

        paint.color = Color.argb(135, 135,64,0)
        canvas.drawCircle(
            (cellSize / 2).toFloat() + 40,
            (cellSize / 2).toFloat(),
            (cellSize / 2).toFloat() - 60,
            paint
        )
    }

    init {
        state["active"] = true
    }
}