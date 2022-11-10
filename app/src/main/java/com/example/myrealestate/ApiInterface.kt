package com.example.myrealestate

import retrofit2.Call
import retrofit2.http.GET
import java.util.Objects

interface ApiInterface {
    @GET( value = "homes")

    fun getData(): Call<ResponseData>

}