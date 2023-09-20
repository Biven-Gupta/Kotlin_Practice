package com.example.kotlinpractice.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {

    @GET("photos")
    fun getData (): Call<List<MyDataItem>>
}