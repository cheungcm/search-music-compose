/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.data.model.music

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Music(
    @Json(name = "collectionId")
    var collectionId: Int = 0,

    @Json(name = "trackId")
    var trackId: Int = 0,

    @Json(name = "artistId")
    var artistId: Int = 0,

    @Json(name = "artistName")
    var artistName: String? = null,

    @Json(name = "collectionName")
    var collectionName: String? = null,

    @Json(name = "trackName")
    var trackName: String? = null,

    @Json(name = "previewUrl")
    var previewUrl: String? = null,

    @Json(name = "artworkUrl30")
    var artworkUrl30: String? = null,

    @Json(name = "artworkUrl60")
    var artworkUrl60: String? = null,

    @Json(name = "artworkUrl100")
    var artworkUrl100: String? = null,

    @Json(name = "trackTimeMillis")
    var trackTimeMillis: Long? = null,

    var isPlaying: Boolean = false
)
