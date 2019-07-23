package com.example.imdbclone.Utils

import com.example.imdbclone.networking.movies.GenresItem

class Genre {

    private val genreMap: HashMap<Int, String> = hashMapOf()

    fun isGenreListLoaded(): Boolean {
        return (true)
    }

    fun loadGenreList(genre: ArrayList<GenresItem>) {

        genre.forEach {
            genreMap[it.id!!] = it.name!!
        }

    }

    fun getGenreName(genreId: Int): String {

        return genreMap[genreId]!!
    }
}