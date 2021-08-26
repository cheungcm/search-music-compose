/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.ccm.common.ui.theme.SearchMusicTheme
import com.ccm.searchmusic.ui.music.Music
import dagger.hilt.android.AndroidEntryPoint

/**
 * Due to insufficient time, all will keep simple as possible:
 * - Language: Kotlin
 * - Deployment Target: Android 7.0+
 * - Compose
 * - MVVM
 * - Retrofit
 * - Dagger Hilt
 * - UI: just use a play arrow, not using player bar binding with notification
 * */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchMusicTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Music()
                }
            }
        }
    }
}
