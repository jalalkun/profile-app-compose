package com.jalalkun.profileappcompose.data.network.service

import com.jalalkun.profileappcompose.data.resultmodel.ResultProfile
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET("api")
    suspend fun getProfile(
        @Query("results") size: Int,
        @Query("page") page: Int
    ): ResultProfile
}