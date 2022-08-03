package com.example.constantatestapp

import com.google.gson.annotations.SerializedName

data class FilmJSON(
    @SerializedName("items")
    val items: List<Item>
)