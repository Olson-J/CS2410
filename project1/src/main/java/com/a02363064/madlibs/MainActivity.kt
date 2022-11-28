package com.a02363064.madlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        // create a label and text field for each word
        // then add both to the screen
        val labelNoun = TextView(this)
        labelNoun.text = "Enter a noun"
        val editTextNoun = EditText(this)
        layout.addView(labelNoun)
        layout.addView(editTextNoun)

        val labelName = TextView(this)
        labelName.text = "Enter a last name"
        val editTextName = EditText(this)
        layout.addView(labelName)
        layout.addView(editTextName)

        val labelAdjective = TextView(this)
        labelAdjective.text = "Enter an adjective"
        val editTextAdjective = EditText(this)
        layout.addView(labelAdjective)
        layout.addView(editTextAdjective)

        val labelOccupation = TextView(this)
        labelOccupation.text = "Enter an occupation (plural)"
        val editTextOccupation = EditText(this)
        layout.addView(labelOccupation)
        layout.addView(editTextOccupation)

        val labelAction = TextView(this)
        labelAction.text = "Enter an action verb"
        val editTextAction = EditText(this)
        layout.addView(labelAction)
        layout.addView(editTextAction)

        val output = TextView(this)

        // create a button to print the madlib
        val button = Button(this)
        button.text = "Generate MadLib"
        button.setOnClickListener{
            // combine all the given words with the story
            val noun = editTextNoun.text.toString()
            val name = editTextName.text.toString()
            val adjective = editTextAdjective.text.toString()
            val occupation = editTextOccupation.text.toString()
            val activity = editTextAction.text.toString()
            output.text = "Welcome to $noun University! We have many $adjective classes " +
                    "that can interest all kinds of $occupation. In your spare time, feel " +
                    "free to $activity across campus, and make sure to wave hello to Professor " +
                    "$name if you see them!"
        }

        layout.addView(button)
        layout.addView(output)

        setContentView(layout)
    }
}