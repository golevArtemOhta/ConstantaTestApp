package com.example.constantatestapp.data

import retrofit2.http.GET

interface ApiRequests {
    @GET("films.json")
    suspend fun getFilms(): FilmDto
}