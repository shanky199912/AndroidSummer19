package com.example.networking_okhttp

data class Github(
    val login: String,
    val avatar_url: String,
    val id: Int
)

data class GithubUser(
//    val total_count: Int,
//    val incomplete_results: Boolean,
    val items: ArrayList<Github>
)