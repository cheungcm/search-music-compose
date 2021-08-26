package com.ccm.searchmusic.ui.music.repository

import com.ccm.searchmusic.ui.music.model.MusicNetworkState
import kotlinx.coroutines.flow.Flow

interface MusicRepository {

    fun getMusics(query: String, limit: Int): Flow<MusicNetworkState>
}
