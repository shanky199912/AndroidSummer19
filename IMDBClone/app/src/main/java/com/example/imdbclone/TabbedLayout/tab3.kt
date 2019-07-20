package com.example.imdbclone.TabbedLayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.imdbclone.R
import com.example.imdbclone.adapter.MovieAdapter
import com.example.imdbclone.adapter.MovieAdapterSmall
import com.example.imdbclone.networking.movies.ResultsItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class tab3 : Fragment() {

    private var mNowShowing = arrayListOf<ResultsItem>()
    private var mPopular = arrayListOf<ResultsItem>()
    private var mTopRated = arrayListOf<ResultsItem>()
    private var mUpcoming = arrayListOf<ResultsItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_tab3, container, false)

        /*val mNowShowingAdapter = MovieAdapter(context!!, mNowShowing)
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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =

            tab3().apply {
                arguments = Bundle().apply {

                    this.putString("title", param1)
                }
            }

    }

}
