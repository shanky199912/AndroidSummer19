package com.example.imdbclone.networking

import com.example.imdbclone.networking.movies.ResponseNowShowing
import com.example.imdbclone.networking.movies.ResponsePopular
import com.example.imdbclone.networking.movies.ResponseTopRated
import com.example.imdbclone.networking.movies.ResponseUpcoming
import retrofit2.Call
import retrofit2.http.GET
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

}