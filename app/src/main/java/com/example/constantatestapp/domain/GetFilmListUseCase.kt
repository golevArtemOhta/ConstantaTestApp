package com.example.constantatestapp.domain

import com.example.constantatestapp.data.Item

class GetFilmListUseCase(private val filmListRepository: FilmListRepository) {

    suspend fun getFilmList(): List<Item> {
        return filmListRepository.getFilmList()
    }

}