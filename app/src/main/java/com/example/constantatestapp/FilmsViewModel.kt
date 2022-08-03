package com.example.constantatestapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FilmsViewModel : ViewModel() {

    val itemsFilms = MutableLiveData<List<Item>>()
    private val api = RetrofitFactory.new()
    val repositry = Repository()
    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            val films = repositry.getFilms()
            itemsFilms.postValue(films)
        }

    }

}