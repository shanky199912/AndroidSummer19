package com.example.imdbclone


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.imdbclone.TabbedLayout.*
import com.example.imdbclone.adapter.MovieAdapter
import com.example.imdbclone.adapter.MovieAdapterSmall
/*import com.example.imdbclone.networking.Client.API_KEY
import com.example.imdbclone.networking.Client.retrofitCallBack
import com.example.imdbclone.networking.Client.service*/
import com.example.imdbclone.networking.movies.ResultsItem
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

    private lateinit var pageAdapter: PagerAdapter
    private var list = arrayListOf<String>("now showing", "upcoming", "top rated")
    private var listFrag = arrayListOf<Fragment>(tab1(), tab2())
    private lateinit var viewpager: ViewPager

    private var mNowShowing = arrayListOf<ResultsItem>()
    private var mPopular = arrayListOf<ResultsItem>()
    private var mTopRated = arrayListOf<ResultsItem>()
    private var mUpcoming = arrayListOf<ResultsItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie, container, false)

      /*  val mNowShowingAdapter = MovieAdapter(context!!, mNowShowing)
        val mPopularAdapter = MovieAdapterSmall(context!!, mPopular)
        val mUpcomingAdapter = MovieAdapter(context!!, mUpcoming)
        val mTopRatedAdapter = MovieAdapterSmall(context!!, mTopRated)*/

//        rcvNowShowing.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        rcvNowShowing.adapter = mNowShowingAdapter
//
//        rcvPopular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        rcvPopular.adapter = mPopularAdapter
//
//        rcvTopRated.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        rcvTopRated.adapter = mTopRatedAdapter
//
//        rcvUpcoming.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        rcvUpcoming.adapter = mUpcomingAdapter
//
/*
        service.listNowShowing(API_KEY,1,"IN").enqueue(retrofitCallBack { response, throwable ->

            response?.let {


            }

            throwable?.let {

            }

        })*/


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
