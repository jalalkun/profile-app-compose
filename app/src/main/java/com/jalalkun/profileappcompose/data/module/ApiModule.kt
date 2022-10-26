package com.jalalkun.profileappcompose.data.module

import com.jalalkun.profileappcompose.data.network.service.UsersService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(UsersService::class.java) }
}