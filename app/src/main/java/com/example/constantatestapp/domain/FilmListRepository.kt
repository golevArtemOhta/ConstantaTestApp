package com.example.constantatestapp.domain

import com.example.constantatestapp.data.RetrofitFactory

interface FilmListRepository {
    suspend fun getFilmList(): List<Item>
}