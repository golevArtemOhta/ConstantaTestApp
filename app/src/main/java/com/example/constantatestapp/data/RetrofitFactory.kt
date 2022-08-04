package com.example.constantatestapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun new() = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/constanta-android-dev/intership-wellcome-task/main/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequests::class.java)
}