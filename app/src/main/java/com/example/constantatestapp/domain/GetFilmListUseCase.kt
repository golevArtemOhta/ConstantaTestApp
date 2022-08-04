package com.example.constantatestapp.domain

class GetFilmListUseCase(private val filmListRepository: FilmListRepository) {

    suspend fun getFilmList(): List<Item> {
        return filmListRepository.getFilmList()
    }

}