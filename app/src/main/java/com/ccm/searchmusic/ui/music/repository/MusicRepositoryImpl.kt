/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.repository

import com.ccm.searchmusic.data.api.MusicService
import com.ccm.searchmusic.ui.music.model.MusicNetworkState
import javax.inject.Inject
import kotlinx.coroutines.flow.flow

class MusicRepositoryImpl @Inject constructor(
    private val service: MusicService
) : MusicRepository {

    override fun getMusics(query: String, limit: Int) = flow {
        try {
            val response = service.searchMusics(term = query, limit = limit)
            emit(MusicNetworkState.Success(response.results))
        } catch (t: Throwable) {
            emit(MusicNetworkState.Failure(t))
        }
    }
}
