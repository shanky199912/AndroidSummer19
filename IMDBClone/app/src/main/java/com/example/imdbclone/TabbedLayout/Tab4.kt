package com.example.imdbclone.TabbedLayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.imdbclone.R
import com.example.imdbclone.adapter.MovieAdapter
import com.example.imdbclone.adapter.MovieAdapterSmall
import com.example.imdbclone.networking.movies.ResultsItem
import kotlinx.android.synthetic.main.fragment_tab4.*
import kotlinx.android.synthetic.main.fragment_tab4.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Tab4 : Fragment() {

    private var mPopular = arrayListOf<ResultsItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_tab4, container, false)

        val mPopularAdapter = MovieAdapterSmall(context!!, mPopular)


        view.rcvPopular.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        view.rcvPopular.adapter = mPopularAdapter

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =

            Tab4().apply {
                arguments = Bundle().apply {

                    this.putString("title", param1)
                }
            }

    }

}
