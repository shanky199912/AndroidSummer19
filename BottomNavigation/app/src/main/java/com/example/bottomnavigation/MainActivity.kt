package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean = when(item.itemId) {

        R.id.navigation_home -> {
            /*textMessage.setText(R.string.title_home)*/
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,Fragment1())
                .commit()
            true
        }
        R.id.navigation_dashboard -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,Fragment2()).commit()
           /* textMessage.setText(R.string.title_dashboard)*/
            true
        }
        R.id.navigation_notifications -> {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,Fragment3()).commit()
           /* textMessage.setText(R.string.title_notifications)*/
            true
        }

        else -> false
    }


}
