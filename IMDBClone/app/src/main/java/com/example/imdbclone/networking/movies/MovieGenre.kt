package com.example.imdbclone.networking.movies

import com.google.gson.annotations.SerializedName

data class MovieGenre(

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null
)