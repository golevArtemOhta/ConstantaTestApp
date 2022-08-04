package com.example.constantatestapp.data

import com.example.constantatestapp.domain.FilmJSON
import retrofit2.http.GET

interface ApiRequests {
    @GET("films.json")
    suspend fun getFilms(): FilmJSON
}