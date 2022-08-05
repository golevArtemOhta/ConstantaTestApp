package com.example.constantatestapp.data

import com.example.constantatestapp.data.Actor

data class Item(
    val actors: List<Actor>,
    val directorName: String,
    val releaseYear: Int,
    val title: String
)