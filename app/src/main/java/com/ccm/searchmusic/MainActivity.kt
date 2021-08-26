package com.ccm.searchmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.ccm.searchmusic.ui.theme.SearchMusicTheme
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
//                    Music()
                }
            }
        }
    }
}
