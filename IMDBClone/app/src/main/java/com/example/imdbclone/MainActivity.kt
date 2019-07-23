package com.example.imdbclone

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import com.example.imdbclone.NetworkCalls.aboutFragment
import com.example.imdbclone.NetworkCalls.favoritesFragment
import com.example.imdbclone.NetworkCalls.movieFragment
import com.example.imdbclone.NetworkCalls.tvShowFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Movies"

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, movieFragment()).commit()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_movies -> {
                // Handle the Movie - open the movie fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, movieFragment()).commit()
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)
                supportActionBar?.title = "Movies"
            }
            R.id.nav_tvShows -> {
                //open up tv show fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, tvShowFragment()).commit()
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)
                supportActionBar?.title = "Tv Shows"
            }
            R.id.nav_favorites -> {
                //open favorites fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, favoritesFragment()).commit()
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)
                supportActionBar?.title = "Favorites"
            }
            R.id.nav_about -> {
                //open about fragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, aboutFragment()).commit()
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)
                supportActionBar?.title = "About"
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
