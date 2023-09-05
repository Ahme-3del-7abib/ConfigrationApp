package com.sewedy.electrometer.core.remote

sealed class Resource<T>(val data: T? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(val errorTypes: ErrorTypes) : Resource<T>()
}
