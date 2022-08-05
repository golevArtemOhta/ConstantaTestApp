package com.example.constantatestapp.data

import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("items")
    val items: List<Item>
)