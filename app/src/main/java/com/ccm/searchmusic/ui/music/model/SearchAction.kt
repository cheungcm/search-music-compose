/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music.model

import com.ccm.searchmusic.data.model.music.Music

sealed class SearchAction {
    data class QueryChange(val query: String = "") : SearchAction()
    object Search : SearchAction()

    data class PlayMusic(val music: Music) : SearchAction()

//    data class AddError(val error: Throwable) : SearchAction()
//    object ClearError : SearchAction()
}
