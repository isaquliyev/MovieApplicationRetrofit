package com.example.tasksolution2505.api

import com.example.tasksolution2505.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("search/movie")
    fun getMovie(@Query("api_key") apiKey: String, @Query("query") query : String) : Call<Results>

    @GET("movie/upcoming")
    fun getUpcomingMovie(@Query("api_key")apiKey : String ) : Call<Results>

    @GET("movie/popular")
    fun getPopularMovie(@Query("api-key")apiKey : String) : Call<Results>
}