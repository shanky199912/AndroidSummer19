package com.example.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var buttonArray = arrayOfNulls<Array<Button>?>(9)

    private var player1turn: Boolean = true

    var roundCount: Int = 0

    private var player1pts: Int = 0
    private var player2pts: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonArray = Array(3) {
            Array(3) {
                Button(this)
            }
        }

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonId: String = "button_$i$j"
                val resId: Int = resources.getIdentifier(buttonId, "id", packageName)
                buttonArray[i]!![j] = findViewById(resId)
                buttonArray[i]?.get(j)?.setOnClickListener(this@MainActivity)
            }
        }

        button_reset.setOnClickListener {
            text_p1.text = "Player 1: 0"
            text_p2.text = "Player 2: 0"
            player1pts=0
            player2pts=0

            Toast.makeText(this@MainActivity, "New Game", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {

        Log.e("hello", "clicked")

        val isSelected = v as Button

        if (!isSelected.text.toString().equals("")) {
            return
        }

        if (player1turn) {

            isSelected.text = "X"
        } else
            isSelected.text = "O"


        roundCount++

        if (checkForWin()) {
            if (player1turn) {
                player1Wins()
            } else
                player2Wins()
        } else if (roundCount == 9) {
            draw()
        } else
            player1turn = !player1turn
    }

    private fun checkForWin(): Boolean {

        var field = arrayOfNulls<Array<String>?>(9)

        field = Array(3) {
            Array(3) {
                String()
            }
        }

        for (i in 0..2) {
            for (j in 0..2) {

                field[i]!![j] = buttonArray[i]!![j].text.toString()
            }
        }

        for (i in 0..2) {
            if (field[i]!![0].equals(field[i]!![1])
                && field[i]!![0].equals(field[i]!![2])
                && !field[i]!![0].equals("")
            ) {

                return true
            }
        }

        for (i in 0..2) {
            if (field[0]!![i].equals(field[1]!![i])
                && field[0]!![i].equals(field[2]!![i])
                && !field[0]!![i].equals("")
            ) {

                return true
            }
        }

        if (field[0]!![0].equals(field[1]!![1])
            && field[0]!![0].equals(field[2]!![2])
            && !field[0]!![0].equals("")
        ) {

            return true
        }

        if (field[0]!![2].equals(field[1]!![1])
            && field[0]!![2].equals(field[2]!![0])
            && !field[0]!![2].equals("")
        ) {

            return true
        }

        return false
    }

    private fun draw() {

        Toast.makeText(this, "Match is Draw", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    private fun player2Wins() {

        player2pts++
        text_p2.text = "Player 2: $player2pts"
        Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    private fun player1Wins() {

        player1pts++
        text_p1.text = "Player 1: $player1pts"
        Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    private fun resetBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                buttonArray[i]?.get(j)?.text = ""
            }
        }
        roundCount = 0
        player1turn = true
    }
}
