package com.example.constantatestapp.domain

import com.example.constantatestapp.data.Item

interface FilmListRepository {
    suspend fun getFilmList(): List<Item>
}