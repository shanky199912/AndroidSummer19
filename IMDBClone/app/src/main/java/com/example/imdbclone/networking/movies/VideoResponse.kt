package com.example.imdbclone.networking.movies

import com.google.gson.annotations.SerializedName

data class VideoResponse(

    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("results")
    val results: ArrayList<Videos?>? = null
)