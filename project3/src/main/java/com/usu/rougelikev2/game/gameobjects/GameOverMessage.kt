package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject


class GameOverMessage(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
        // this object is a little different than the others as is doesn't have a position inherently.
        // its position is determined at render time.
        // here are some of the things that will be useful for you.
        // game.height // get the height of the game
        // game.width; // get the width of the game
        val isPlaying: Boolean = game.gameState["playing"]
        if (isPlaying) return
        paint.color = Color.DKGRAY
        canvas.drawRect(0f, 0f, game.width, game.height, paint)

        // body
        paint.color = Color.BLUE
        canvas.drawCircle(game.width / 2, game.height / 2,
            250f, paint)


        // hat
        paint.color = Color.BLACK
        canvas.drawRect(230f, 850f,850f, 900f, paint) // brim
        canvas.drawRect(320f, 850f, 760f, 650f, paint) //hat

        // hat band
        paint.color = Color.RED
        canvas.drawRect(320f, 830f, 760f, 850f, paint)

        // eyes
        paint.color = Color.BLACK
        var eyeMidLeft = 430
        var eyeMidRight = eyeMidLeft + 20
        var eyeMidTop = 1030
        var eyeMidBot = eyeMidTop - 20

        canvas.drawRect(eyeMidLeft.toFloat(), eyeMidTop.toFloat(), eyeMidRight.toFloat(),
            eyeMidBot.toFloat(), paint)
        canvas.drawRect(eyeMidLeft.toFloat() - 20, eyeMidTop.toFloat() - 20, eyeMidRight.toFloat() - 20,
            eyeMidBot.toFloat() - 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() - 20, eyeMidTop.toFloat() + 20, eyeMidRight.toFloat() - 20,
            eyeMidBot.toFloat() + 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() + 20, eyeMidTop.toFloat() - 20, eyeMidRight.toFloat() + 20,
            eyeMidBot.toFloat() - 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() + 20, eyeMidTop.toFloat() + 20, eyeMidRight.toFloat() + 20,
            eyeMidBot.toFloat() + 20, paint)

        eyeMidLeft = 630
        eyeMidRight = eyeMidLeft + 20
        eyeMidTop = 1030
        eyeMidBot = eyeMidTop - 20

        canvas.drawRect(eyeMidLeft.toFloat(), eyeMidTop.toFloat(), eyeMidRight.toFloat(),
            eyeMidBot.toFloat(), paint)
        canvas.drawRect(eyeMidLeft.toFloat() - 20, eyeMidTop.toFloat() - 20, eyeMidRight.toFloat() - 20,
            eyeMidBot.toFloat() - 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() - 20, eyeMidTop.toFloat() + 20, eyeMidRight.toFloat() - 20,
            eyeMidBot.toFloat() + 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() + 20, eyeMidTop.toFloat() - 20, eyeMidRight.toFloat() + 20,
            eyeMidBot.toFloat() - 20, paint)
        canvas.drawRect(eyeMidLeft.toFloat() + 20, eyeMidTop.toFloat() + 20, eyeMidRight.toFloat() + 20,
            eyeMidBot.toFloat() + 20, paint)

        // mouth
        canvas.drawRect(420f, 1150f, 660f, 1155f, paint)
        paint.color = Color.RED
        canvas.drawRect(620f, 1158f, 660f, 1200f, paint)
        paint.color = Color.BLACK
        canvas.drawRect(635f, 1158f, 640f, 1185f, paint)


        paint.color = Color.RED
        paint.textSize = 150f
        canvas.drawText("GAME OVER", game.width / 7, game.height - 300, paint)
    }
}