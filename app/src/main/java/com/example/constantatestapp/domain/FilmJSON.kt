package com.example.constantatestapp.domain

import com.google.gson.annotations.SerializedName

data class FilmJSON(
    @SerializedName("items")
    val items: List<Item>
)