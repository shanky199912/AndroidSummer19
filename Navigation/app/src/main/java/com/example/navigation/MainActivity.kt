package com.example.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val menuInflater = menuInflater
         menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toobar)
        supportActionBar?.title ="hello"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean  {

        val a  = when(item?.itemId){

            R.id.firstButton ->{

                val i = Intent(this,Main2Activity::class.java)
                startActivity(i)
                false
            }

            R.id.second ->{
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }

        return true
    }
}
