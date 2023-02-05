package com.jalalkun.profileappcompose.data.repository

import com.jalalkun.profileappcompose.data.network.service.UsersService
import com.jalalkun.profileappcompose.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

class ProfileRepository(private val usersService: UsersService) {
    fun getProfiles(size: Int, page: Int): Flow<Resource> = flow {
        emit(Resource.Loading)
        try {
            val response = usersService.getProfile(
                size = size,
                page = page
            ).results
            kotlinx.coroutines.delay(2000)
            emit(Resource.Success(response))
        }catch (e: HttpException){
            emit(Resource.Error("Error ${e.message()}"))
        }catch (e: Exception){
            emit(Resource.Error("Error ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)
}