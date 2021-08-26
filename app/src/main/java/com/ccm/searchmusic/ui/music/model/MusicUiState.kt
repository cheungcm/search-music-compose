/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.model

import com.ccm.searchmusic.data.model.music.Music

// sealed class MusicUiState {
//    object Empty : MusicUiState()
//    data class Success(val data: List<Music> = arrayListOf()) : MusicUiState()
//    data class Error(val exception: Throwable) : MusicUiState()
// }
data class MusicUiState(
    val data: List<Music> = arrayListOf(),
    val error: Throwable? = null,
) {
    companion object {
        val Empty = MusicUiState()
    }
}
