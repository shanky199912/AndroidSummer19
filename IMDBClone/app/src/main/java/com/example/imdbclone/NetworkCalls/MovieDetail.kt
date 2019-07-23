package com.example.imdbclone.NetworkCalls

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imdbclone.R
import com.example.imdbclone.adapter.CastAdapter
import com.example.imdbclone.adapter.SimilarMoviesAdapter
import com.example.imdbclone.adapter.VideosAdapter
import com.example.imdbclone.networking.Client.API_KEY
import com.example.imdbclone.networking.Client.retrofitCallBack
import com.example.imdbclone.networking.Client.service
import com.example.imdbclone.networking.movies.CastItem
import com.example.imdbclone.networking.movies.Movie
import com.example.imdbclone.networking.movies.ResultsItem
import com.example.imdbclone.networking.movies.Videos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {

    private var listDetail: ArrayList<Movie> = arrayListOf()
    private var listCast: ArrayList<CastItem?>? = arrayListOf()
    private var listTrailer: ArrayList<Videos?>? = arrayListOf()
    private var listMovie: ArrayList<ResultsItem?>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)


        val mMovieId = intent.getIntExtra("MovieId", 55 )
        Log.i("movieid", mMovieId.toString())


        service.getMovieDetails(mMovieId, API_KEY).enqueue(retrofitCallBack { response, throwable ->

            response?.let {

                runOnUiThread {

                    Picasso.get()
                        .load("https://image.tmdb.org/t/p/original" + response.body()?.backdropPath)
                        .fit()
                        .centerCrop()
                        .into(imageViewBack)

                    Picasso.get()
                        .load("https://image.tmdb.org/t/p/original" + response.body()?.posterPath)
                        .fit()
                        .centerCrop()
                        .into(imageViewMovie)

                    if (textMovieName.text != null) {

                        textMovieName.text = response.body()?.originalTitle
                    } else
                        textMovieName.text = ""

                    if (textMovieGenre.text != null) {

                    }


                    if (movSelTxtRat.text != null) {
                        movSelTxtRat.text = response.body()?.voteAverage.toString()
                    } else
                        movSelTxtRat.text = ""

                    if (movSelTxtDes.text != null) {
                        movSelTxtDes.text = response.body()?.overview
                    } else
                        movSelTxtDes.text = ""

                    if (movSelTxtDuration.text != null) {
                        movSelTxtDuration.text = "Duration: ${response.body()?.runtime.toString()}"
                    } else
                        movSelTxtDuration.text = ""

                    if (movSelTxtReleasedate.text != null) {
                        movSelTxtReleasedate.text = "Release Date: ${response.body()?.releaseDate.toString()}"
                    } else
                        movSelTxtReleasedate.text = ""
                }
            }

            throwable?.let {

            }
        })

        service.getMovieVideos(mMovieId, API_KEY).enqueue(retrofitCallBack { response, throwable ->

            response?.let {

                this.runOnUiThread {


                    listTrailer = response.body()!!.results
                    val trailerAdapter = VideosAdapter(this, listTrailer)
                    rcvTrailers.layoutManager = LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL, false
                    )
                    rcvTrailers.adapter = trailerAdapter
                }
            }

            throwable?.let {

            }
        })

        service.getMovieCast(mMovieId, API_KEY).enqueue(retrofitCallBack { response, throwable ->

            response?.let {
                this.runOnUiThread {

                    listCast = response.body()?.cast

                    val castAdapter = CastAdapter(this, listCast)
                    rcvCast.layoutManager = LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL, false
                    )
                    rcvCast.adapter = castAdapter
                }
            }
            throwable?.let {

            }
        })

        service.getSimilarMovies(mMovieId, API_KEY, 1).enqueue(retrofitCallBack { response, throwable ->

            response?.let {
                this.runOnUiThread {

                    listMovie = response.body()?.results
                    val movieAdapter = SimilarMoviesAdapter(this, listMovie)
                    rcvSimilarMovies.layoutManager = LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL, false
                    )
                    rcvSimilarMovies.adapter = movieAdapter

                }
            }
        })
    }

}
