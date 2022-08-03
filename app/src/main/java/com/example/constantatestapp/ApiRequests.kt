package com.example.constantatestapp

import retrofit2.http.GET

interface ApiRequests {
    @GET("films.json")
    suspend fun getFilms(): FilmJSON
}