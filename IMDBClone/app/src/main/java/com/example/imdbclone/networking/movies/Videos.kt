package com.example.imdbclone.networking.movies

import com.google.gson.annotations.SerializedName

data class Videos(

    @SerializedName("id")
    val id: String? = null,
//iso_639_1 missing
//iso_3166_1 missing
    @SerializedName("key")
    val key: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("site")
    val site: String? = null,
    @SerializedName("size")
    val size: Int? = null,
    @SerializedName("type")
    val type: String? = null
)