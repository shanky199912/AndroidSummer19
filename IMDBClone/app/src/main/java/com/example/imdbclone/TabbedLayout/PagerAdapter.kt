package com.example.imdbclone.TabbedLayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class PagerAdapter(fm: FragmentManager?,context: Context) : FragmentStatePagerAdapter(fm!!) {

    private val movies: ArrayList<String> = ArrayList()
    private val frag: ArrayList<Fragment> = ArrayList()

    override fun getPageTitle(position: Int): CharSequence? {

        /*return when (movies[position]) {

            movies[0] -> "Now showing"
            movies[1] -> "Popular"
            movies[2] -> "Upcoming"

            else -> "no title"
        }*/
        return movies[position]

    }

    fun addFragment(fragment: Fragment, title: String) {

        frag.add(fragment)
        movies.add(title)

    }

    override fun getItem(position: Int): Fragment {

        /* return when (movies[position]) {

             movies[0] -> tab1()

             movies[1] -> tab2()

             movies[2] -> tab3()

             else -> Fragment()

         }
 */
        return frag[position]

        //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {

        return movies.size
        //To change body of created functions use File | Settings | File Templates.
    }

}