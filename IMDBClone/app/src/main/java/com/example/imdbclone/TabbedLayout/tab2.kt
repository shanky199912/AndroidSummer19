package com.example.imdbclone.TabbedLayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.imdbclone.R
import kotlinx.android.synthetic.main.fragment_tab2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class tab2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv2.text = "Fragment 2"
    }

    companion object{

        @JvmStatic
        fun newInstance(param1: String)  =

            tab2().apply {
                arguments = Bundle().apply {

                    this.putString("title", param1)
                }
            }

    }


}