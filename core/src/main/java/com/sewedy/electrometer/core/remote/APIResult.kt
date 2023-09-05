package com.sewedy.electrometer.core.remote

sealed class APIResult<out T : Any> {
    data class Success<out T : Any>(val data: T?) : APIResult<T>()
    data class Error(val errorTypes: ErrorTypes) : APIResult<Nothing>()
}
