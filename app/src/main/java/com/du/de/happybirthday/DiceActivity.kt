package com.du.de.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class DiceActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        val rollButton: Button = findViewById(R.id.btnRoll)

        // Find the ImageView in the layout
        diceImage = findViewById(R.id.ivDice)

        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {

        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResouce = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceAnimation(diceImage, diceRoll, drawableResouce)
    }

    /**
     * Function for making the dice roll with animation.
     */
    private fun diceAnimation(diceImage: ImageView, diceRoll: Int, drawableResouce: Int) {
        diceImage.animate().apply {
            duration = 1000
            rotationXBy(1800f)
            rotationYBy(1800f)
            diceImage.isClickable = false
        }.withEndAction(){
            // Update the ImageView with the correct drawable resource ID
            diceImage.setImageResource(drawableResouce)
            // Update the content description
            diceImage.contentDescription = diceRoll.toString()
            diceImage.isClickable = true
        }.start()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
