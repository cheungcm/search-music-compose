/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.repository

import com.ccm.searchmusic.base.NetworkResult
import com.ccm.searchmusic.data.model.music.Music
import kotlinx.coroutines.flow.Flow

interface MusicRepository {

    fun getMusics(query: String, limit: Int): Flow<NetworkResult<List<Music>>>
}
