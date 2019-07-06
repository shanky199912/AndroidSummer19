package com.example.othello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ll: LinearLayout
    private lateinit var ll1: LinearLayout
    private lateinit var blackTv: TextView
    private lateinit var whiteTv: TextView
    private lateinit var ll2: LinearLayout
    private lateinit var ll3: LinearLayout

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

        ll2 = LinearLayout(this)
        ll2.orientation = LinearLayout.VERTICAL

        ll2.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        ll3 = LinearLayout(this)
        ll3.orientation = LinearLayout.HORIZONTAL

        ll3.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        ll1 = LinearLayout(this)
        ll1.orientation = LinearLayout.VERTICAL

        button = Array(8) {
            Array(8) {
                Button(this)
            }
        }


        llayout = Array(8) {
            LinearLayout(this)
        }


        for (i in 0..7) {

            llayout[i]?.apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT, 1f
                )
                orientation = LinearLayout.VERTICAL
            }

            for (j in 0..7) {

                button[i]!![j].layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                button[i]!![j].setBackgroundColor(resources.getColor(R.color.dark_orange))
                val params = button[i]!![j].layoutParams as LinearLayout.LayoutParams
                params.setMargins(6, 6, 0, 0)
                button[i]!![j].layoutParams = params
                button[i]!![j].textSize = 35f

                if (button[i]!![j].parent != null) (button[i]!![j].parent as ViewGroup).removeView(button[i]!![j])
                llayout[i]!!.addView(button[i]!![j])
            }

            if (llayout[i]!!.parent != null) {
                (llayout[i]!!.parent as ViewGroup).removeView(llayout[i])
            }
            ll.addView(llayout[i])

        }


        blackTv = TextView(this)
        blackTv.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1f
        )
        blackTv.text = "Black : 0"
        blackTv.textSize = 30f
        val param = blackTv.layoutParams as LinearLayout.LayoutParams
        param.setMargins(10, 20, 20, 20)
        blackTv.layoutParams = param

        ll3.addView(blackTv)

        whiteTv = TextView(this)
        whiteTv.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, 1f
        )
        whiteTv.text = "White : 0"
        whiteTv.textSize = 30f
        val params2 = whiteTv.layoutParams as LinearLayout.LayoutParams
        params2.setMargins(20, 20, 10, 20)
        whiteTv.layoutParams = params2

        ll3.addView(whiteTv)

        ll2.addView(ll3)

        ll2.addView(ll)


        setContentView(ll2)

        button[3]!![3].text = "\u2B24"
        button[3]!![4].text = "\u26AA"
        button[4]!![3].text = "\u26AA"
        button[4]!![4].text = "\u2B24"

        for (i in 0..7) {
            for (j in 0..7) {

                buttonArray[i]!![j] = button[i]!![j]
                buttonArray[i]!![j].setOnClickListener(this)
            }
        }

    }

    override fun onClick(v: View?) {

        val isSelected = v as Button

        if (blackTurn) {

            isSelected.text = "\u2B24"
        } else {
            isSelected.text = "\u26AA"
        }

    }


    /* startGame.setOnClickListener {

         buttonArray[3]!![3].text = "\u2B24"
         buttonArray[3]!![4].text = "\u26AA"
         buttonArray[4]!![3].text = "\u26AA"
         buttonArray[4]!![4].text = "\u2B24"

     }*/
}

/*override fun onClick(v: View?) {

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

}*/


