package com.example.imdbclone.NetworkCalls


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imdbclone.R
import com.example.imdbclone.TabbedLayout.*
/*import com.example.imdbclone.networking.Client.API_KEY
import com.example.imdbclone.networking.Client.retrofitCallBack
import com.example.imdbclone.networking.Client.service*/
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_movie.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class movieFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = PagerAdapter(fragmentManager)
        val tab1 = tab1()
        adapter.addFragment(tab1, "Now Showing")
        adapter.addFragment(tab2.newInstance("tab2"), "Upcoming")
        adapter.addFragment(tab3.newInstance("tab3"), "Top Rated")
        adapter.addFragment(Tab4.newInstance("tab4"), "Popular")
        view.pager.adapter = adapter
        tabLayout.setupWithViewPager(view.pager)
        //  tabLayout.getTabAt(0).setIcon()
       // pager.offscreenPageLimit = 3
    }


}
