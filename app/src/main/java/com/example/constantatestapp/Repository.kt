package com.example.constantatestapp

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Repository {




    private val api = RetrofitFactory.new()


    suspend fun getFilms(): List<Item> {
            val films = api.getFilms()
            return films.items
    }
}