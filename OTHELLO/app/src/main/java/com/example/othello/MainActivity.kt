package com.example.othello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity() {

    lateinit var ll: LinearLayout
    lateinit var ll1: LinearLayout

    var button = arrayOfNulls<Array<Button>?>(64)
    private var llayout = arrayOfNulls<LinearLayout?>(8)

    private var blackTurn: Boolean = true

    /**
     * An array of Nulls is created of size 64 and type Button
     */
    private var buttonArray = arrayOfNulls<Array<Button>?>(64)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        /**
         * Code for the dynamic creation of Buttons
         */
        ll = LinearLayout(this)
        ll.orientation = LinearLayout.HORIZONTAL

        ll.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        ll1 = LinearLayout(this)
        ll1.orientation = LinearLayout.VERTICAL

        ll1.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
        )

        button = Array(8){
            Array(8){
                Button(this)
            }
        }



        llayout = Array(8) {
            LinearLayout(this)
        }

        llayout.forEach {

            val apply = it.apply {


                for (j in 1..8) {

                    button[1]!![j].minHeight = 0
                    button[1]!![j].minWidth = 0
                    button[1]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[1]!![j])
                }

                for (j in 1..8) {


                    button[2]!![j].minHeight = 0
                    button[2]!![j].minWidth = 0
                    button[2]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[2]!![j])
                }

                for (j in 1..8) {


                    button[3]!![j].minHeight = 0
                    button[3]!![j].minWidth = 0
                    button[3]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[3]!![j])
                }

                for (j in 1..8) {

                    button[4]!![j].minHeight = 0
                    button[4]!![j].minWidth = 0
                    button[4]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[4]!![j])
                }

                for (j in 1..8) {


                    button[5]!![j].minHeight = 0
                    button[5]!![j].minWidth = 0
                    button[5]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[5]!![j])
                }

                for (j in 1..8) {


                    button[6]!![j].minHeight = 0
                    button[6]!![j].minWidth = 0
                    button[6]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[6]!![j])
                }

                for (j in 1..8) {


                    button[7]!![j].minHeight = 0
                    button[7]!![j].minWidth = 0
                    button[7]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[7]!![j])
                }

                for (j in 1..8) {

                    button[8]!![j].minHeight = 0
                    button[8]!![j].minWidth = 0
                    button[8]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                    ll1.addView(button[8]!![j])
                }


            }

            ll.addView(apply)
        }

        /* *
         * Initializing the 2D Array of Nulls

        buttonArray = Array(8) {

            Array(8) {

                Button(this)
            }
        }

        *
         * Setting the on click Listener to the buttonArray


        for (i in 1..8) {
            for (j in 1..8) {

                val buttonId: String = "bt$i$j"
                val resId = resources.getIdentifier(buttonId, "ID", packageName)
                buttonArray[i]!![j] = findViewById(resId)
                buttonArray[i]!![j].setOnClickListener(this)
            }
        }
    }*/

        /* override fun onClick(v: View?) {

        val isSelected = v as Button

        if (blackTurn) {

            if (checkForValidPlace()) {

                //set the black color to the button
                // v.setBackgroundColor(resources.getColor(R.color.))
            }
        }
    }

    private fun checkForValidPlace(): Boolean {


        return false

    }*/
    }
}
