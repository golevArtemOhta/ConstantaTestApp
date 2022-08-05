package com.example.constantatestapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constantatestapp.data.FilmListRepositoryImpl
import com.example.constantatestapp.domain.GetFilmListUseCase
import com.example.constantatestapp.data.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FilmsViewModel : ViewModel() {

    val itemsFilms = MutableLiveData<List<Item>>()
    private val repository = FilmListRepositoryImpl
    private val getFilmListUseCase = GetFilmListUseCase(repository)

    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val films = getFilmListUseCase.getFilmList()
            itemsFilms.postValue(films)
        }
    }
}