package com.example.constantatestapp.data

import com.example.constantatestapp.domain.FilmListRepository

object FilmListRepositoryImpl : FilmListRepository {

    private val api = RetrofitFactory.new()

    override suspend fun getFilmList(): List<Item> {
        val films = api.getFilms()
        return films.items
    }
}