package com.wgaonar.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // lateinit lets to init a mutable var before setContentView is called
    // var is a general variable and can be asigned multiple times
    lateinit var resultText: TextView
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's Rock and Roll"
        rollButton.setOnClickListener {
            rollDice()
        }

        resultText = findViewById(R.id.result_text)
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        // val is a constant variable and can be initialized only single time
        val randomInt = Random.nextInt(1,7)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(drawableResource)
        resultText.text = randomInt.toString()
    }
}