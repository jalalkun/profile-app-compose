package com.jalalkun.profileappcompose.data.utils

sealed class Resource {
    class Success<T>(val data: T) : Resource()
    class Error(val message: String) : Resource()
    object Loading : Resource()
    object Dismiss : Resource()
}
