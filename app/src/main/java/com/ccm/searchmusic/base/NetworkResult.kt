package com.ccm.searchmusic.base

sealed class NetworkResult<out T> {
    data class Success<out R>(val value: R): NetworkResult<R>()
    data class Failure(
        val code: Int? = null,
        val message: String? = null,
        val throwable: Throwable? = null
    ): NetworkResult<Nothing>()
}