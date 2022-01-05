package com.example.diceroller2

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView
    private lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage.tag = 1
        diceImage2.tag = 1
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener { rollDice() }
        countUpButton.setOnClickListener { countUp() }
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDice() {
        val dice1 = getRandomDiceNumber()
        val dice2 = getRandomDiceNumber()

        diceImage.tag = dice1
        diceImage.setImageResource(getDiceImage(dice1))

        diceImage2.tag = dice2
        diceImage2.setImageResource(getDiceImage(dice2))
    }

    private fun getRandomDiceNumber() : Int {
        return (1..6).random()
    }

    private fun getDiceImage(randomInt : Int) : Int {
       return when (randomInt) {
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
       }
    }

    private fun countUp() {
        var currInt = diceImage.tag as Int
        if (currInt < 6) {
            currInt++
            val drawableResource = when (currInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.tag = currInt
            diceImage.setImageResource(drawableResource)
        }

    }

    private fun reset() {
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage.tag = 1
    }
}