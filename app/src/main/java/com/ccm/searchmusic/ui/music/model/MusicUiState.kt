/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.model

import com.ccm.searchmusic.data.model.music.Music

data class MusicUiState(
    val data: List<Music> = arrayListOf(),
    val error: String? = null,
) {
    companion object {
        val Empty = MusicUiState()
    }
}
