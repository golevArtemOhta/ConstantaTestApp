package com.example.constantatestapp.domain

data class Item(
    val actors: List<Actor>,
    val directorName: String,
    val releaseYear: Int,
    val title: String
)