/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.ccm.common.ui.theme.SearchMusicTheme
import com.ccm.searchmusic.ui.music.Music
import dagger.hilt.android.AndroidEntryPoint

/**
 * Live Music App should be:
 * - Song nav bar on bottom
 * - Song detail page
 * - Stick with a foreground notification
 *
 * But this project only focusing on "software architect skills, design patterns, and coding styles" and this requirements:
 * - MVVM pattern (pure)
 * - Creating layout programmatically (JetPack Compose)
 *
 *
 * Android Developer Assignment:
    The assignment is simple and straightforward. However, the developer is expected to finish it with his/her highest standard.
    It is intended to test the developer's software architect skills, design patterns, and coding styles.

    ● Task: Create an app that let user to search music in iTunes Music.
            The search results shall be displayed in RecyclerView and user can play the preview track.

    ● API: iTunes Search API (DONE)
    ● Language: Kotlin (DONE)
    ● Deployment Target: Android 7.0+ (DONE)
    ● The following are the suggested tools, or anything that can show your skills:
        ○ Design pattern: MVVM, MVP (DONE - MVVM)
        ○ Api Client: Retrofit (DONE)
        ○ Dependency injection: Dragger, Koin (DONE - Dagger Hilt)
    ● The following are nice to include to your project:
        ○ Practice of coding style (DONE)
        ○ Structure between Activities and Fragments (DONE - One Activity)
        ○ Organisation of dimension and style (DONE - compose files)
        ○ Documentation / Descriptions
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
