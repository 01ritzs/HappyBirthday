package com.du.de.happybirthday

fun main() {
    var myFirstDice = DiceActivity()
    val diceRoll = myFirstDice.roll()
    println("Your ${myFirstDice.sides} sided dice rolled ${diceRoll}")

    myFirstDice.sides = 20
    println("Your ${myFirstDice.sides} sided dice rolled ${myFirstDice.roll()}")

}

class DiceActivity {
    var sides = 6

    fun roll() : Int{
        val randomNumber = (1..sides).random()
        return randomNumber
    }
}