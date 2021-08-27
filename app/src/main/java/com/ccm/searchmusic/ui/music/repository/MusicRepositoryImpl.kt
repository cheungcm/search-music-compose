/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.repository

import com.ccm.searchmusic.base.NetworkResult
import com.ccm.searchmusic.data.api.MusicService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val service: MusicService
) : MusicRepository {

    override fun getMusics(query: String, limit: Int) = flow {
        try {
            val response = service.searchMusics(term = query, limit = limit)
            emit(NetworkResult.Success(response.results))
        } catch (t: Throwable) {
            emit(NetworkResult.Failure(message = t.message))
        }
    }
}
