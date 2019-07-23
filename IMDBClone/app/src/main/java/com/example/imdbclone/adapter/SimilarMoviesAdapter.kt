package com.example.imdbclone.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbclone.NetworkCalls.MovieDetail
import com.example.imdbclone.R
import com.example.imdbclone.networking.movies.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rcviewsimilarmovies.view.*

class SimilarMoviesAdapter(private val context: Context, private val listMovie: ArrayList<ResultsItem?>?) :
    RecyclerView.Adapter<SimilarMovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieHolder {
        return SimilarMovieHolder(LayoutInflater.from(context).inflate(R.layout.rcviewsimilarmovies, parent, false))
    }

    override fun getItemCount(): Int {
        return listMovie!!.size //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: SimilarMovieHolder, position: Int) {

        val movie = listMovie?.get(position)
        movie?.let { holder.bind(it) }

        //To change body of created functions use File | Settings | File Templates.
    }

}

class SimilarMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: ResultsItem) {

        Picasso.get()
            .load("https://image.tmdb.org/t/p/original" + movie.posterPath)
            .fit()
            .centerCrop()
            .into(itemView.imgSimilarMovie)

        if (movie.title != null) {

            itemView.txtSimilarMovie.text = movie.originalTitle
        } else
            itemView.txtSimilarMovie.text = ""

        itemView.crdviewSimilarMovies.setOnClickListener {

            val intent = Intent(itemView.context, MovieDetail::class.java)
            intent.putExtra("MovieId",movie.id)
            itemView.context.startActivity(intent)
        }
    }
}