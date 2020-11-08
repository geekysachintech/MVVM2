package com.mrmobo.mvvm2.data.api

import com.google.gson.JsonObject
import com.mrmobo.mvvm2.data.models.SearchResponse
import com.mrmobo.mvvm2.data.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUser(): Response<List<User>>

    @GET("search/users")
    suspend fun searchUser(@Query("q") name: String): Response<SearchResponse>

}
