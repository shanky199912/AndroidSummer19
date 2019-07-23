package com.example.imdbclone.networking

import com.example.imdbclone.networking.movies.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {

    @GET("movie/now_playing")
    fun listNowShowing(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<ResponseNowShowing>

    @GET("movie/popular")
    fun listPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<ResponsePopular>

    @GET("movie/upcoming")
    fun listUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<ResponseUpcoming>

    @GET("movie/top_rated")
    fun listTopRated(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<ResponseTopRated>

    @GET("movie/{id}")
    fun getMovieDetails(
        @Path("id") movieId: Int,
        @Query("API KEY") apiKey: String
    ):Call<Movie>


    @GET("movie/{id}/videos")
    fun getMovieVideos(
        @Path("id") movieId: Int,
        @Query("API KEY") apiKey: String
    ): Call<VideoResponse>


    @GET("movie/{id}/credits")
    fun getMovieCast(
        @Path("id") movieId: Int,
        @Query("API KEY") apiKey: String
    ): Call<ResponseMovieCast>

    @GET("movie/{id}/similar")
    fun getSimilarMovies(
        @Path("id") movieId: Int,
        @Query("API KEY") apiKey: String,
        @Query("page") page: Int
    ): Call<SimilarMovies>


    @GET("genre/movie/list")
    fun getMovieGenreList(
        @Query("api key") apiKey: String
    )

}