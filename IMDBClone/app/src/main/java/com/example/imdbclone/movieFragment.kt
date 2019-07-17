package com.example.imdbclone


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imdbclone.TabbedLayout.PagerAdapter
import com.example.imdbclone.TabbedLayout.tab1
import com.example.imdbclone.TabbedLayout.tab2
import com.example.imdbclone.TabbedLayout.tab3
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie.view.*
import kotlinx.android.synthetic.main.fragment_movie.view.pager


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class movieFragment : Fragment() {

    private lateinit var pageAdapter: PagerAdapter
    private var list = arrayListOf<String>("now showing", "upcoming", "top rated")
    private var listFrag = arrayListOf<Fragment>(tab1(), tab2())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = PagerAdapter(fragmentManager, context!!)
        adapter.addFragment(tab1.newInstance("tab1"), "Now Showing")
        adapter.addFragment(tab2.newInstance("tab2"), "Upcoming")
        adapter.addFragment(tab3.newInstance("tab3"), "Top Rated")
        pager.adapter = adapter
        tabLayout.setupWithViewPager(pager)
        //  tabLayout.getTabAt(0).setIcon()
        pager.offscreenPageLimit = 3

    }


}
