package com.example.imdbclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbclone.R
import com.example.imdbclone.networking.movies.GenresItem
import com.example.imdbclone.networking.movies.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview.view.*

class MovieAdapter(private val context: Context, private val listMovie: ArrayList<ResultsItem?>) :
    RecyclerView.Adapter<MovieViewHolder>() {

    private val listGenre: ArrayList<GenresItem> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return listMovie.size
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = listMovie[position]
        holder.bind(movie)


        // setGenres(holder, listMovie[position])

        //To change body of created functions use File | Settings | File Templates.
    }

    /* private fun setGenres(holder: MovieViewHolder, resultsItem: ResultsItem) {

         val genreString = ""
         for (i in 0..resultsItem.genreIds!!.size){

         }

     }*/

}


class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: ResultsItem?) {

        Picasso.get().load(movie?.posterPath).into(itemView.imgmovie)

        if (movie?.title != null) {

            itemView.txtmovname.text = movie.originalTitle
        } else
            itemView.txtmovname.text = ""

        if (movie?.voteAverage != null && movie.voteAverage > 0) {
            itemView.txtRat.text = movie.voteAverage.toString()
        } else
            itemView.txtRat.visibility = View.GONE
    }

}