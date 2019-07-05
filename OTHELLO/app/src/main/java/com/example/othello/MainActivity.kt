package com.example.othello

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.marginLeft
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

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
        // setContentView(R.layout.activity_main)

        buttonArray = Array(8) {

            Array(8) {

                Button(this)
            }
        }


        /* for (i in 0..7) {
             for (j in 0..7) {

                 val buttonId = "bt$i$j"
                 resources.getIdentifier(buttonId, "id", packageName).apply {
                     buttonArray[i]!![j] = findViewById(this)
                 }
                 buttonArray[i]!![j].setOnClickListener(this@MainActivity)
             }
         }*/


        /**
         * Code for the dynamic creation of Buttons
         */
        ll = LinearLayout(this)
        ll.orientation = LinearLayout.HORIZONTAL

        ll.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        ll1 = LinearLayout(this)
        ll1.orientation = LinearLayout.VERTICAL

        ll1.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1.0f
        )

        ll.removeAllViews()
        ll1.removeAllViews()

        button = Array(8) {
            Array(8) {
                Button(this)
            }
        }


        llayout = Array(8) {
            LinearLayout(this)
        }

        for (i in 0..7) {

            /*llayout.forEach {

                val apply = it?.apply {*/


            for (j in 0..7) {

               button[i]!![j].layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                   LinearLayout.LayoutParams.WRAP_CONTENT)
                button[i]!![j].setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                /*if (button[i]!![j].parent != null) {

                    (button[i]!![j].parent as ViewGroup).removeView(button[i]!![j])
                }*/
                ll1.addView(button[i]!![j])
            }

            if (ll1.parent != null) {
                (ll1.parent as ViewGroup).removeView(ll1)
            }
            ll.addView(ll1)
        }


       /* startGame.setOnClickListener {

            buttonArray[3]!![3].text = "\u2B24"
            buttonArray[3]!![4].text = "\u26AA"
            buttonArray[4]!![3].text = "\u26AA"
            buttonArray[4]!![4].text = "\u2B24"

        }*/
    }

    override fun onClick(v: View?) {

        val isSelected = v as Button

        if (blackTurn) {

            if (checkForValidPlaceBlack() == isSelected.id) {

                //set the black color to the button
                // v.setBackgroundColor(resources.getColor(R.color.))
            }
        }
    }

    private fun checkForValidPlaceBlack(): Int {

        val id: Int = 0

        var placeBlack = arrayOfNulls<Array<String>?>(64)

        placeBlack = Array(8) {
            Array(8) {
                String()
            }
        }
        for (i in 0..7) {
            for (j in 0..7) {

                placeBlack[i]!![j] = buttonArray[i]!![j].text.toString()

            }
        }

        if (buttonArray[0]!![0].text == "B") {

            for (i in 2..7) {
                while (buttonArray[1]!![0].text == "W" &&
                    (buttonArray[i]!![0].text == "" || buttonArray[i]!![0].text == "W")
                ) {

                    if (buttonArray[i]!![0].text == "") {
                        return buttonArray[i]!![0].id
                    } else {
                        return id
                    }
                }
            }

            return id
        }

        if (buttonArray[0]!![7].text == "B") {


            return id
        }

        if (buttonArray[7]!![0].text == "B") {


            return id
        }

        if (buttonArray[7]!![7].text == "B") {


            return id
        }

        for (i in 1..6) {

            if (buttonArray[i]!![0].text == "B") {

                return id
            }

            if (buttonArray[i]!![7].text == "B") {

                return id
            }
        }

        for (j in 1..6) {

            if (buttonArray[0]!![j].text == "B") {

                return id
            }

            if (buttonArray[7]!![j].text == "B") {

                return id
            }
        }


        return id

    }
}

