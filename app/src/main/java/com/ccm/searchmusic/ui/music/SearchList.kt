/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ccm.searchmusic.data.model.music.Music
import com.ccm.searchmusic.ui.components.CoverImage
import com.ccm.searchmusic.ui.components.PlayIcon
import com.ccm.searchmusic.ui.music.model.MusicUiState
import com.ccm.searchmusic.ui.music.model.SearchAction
import com.ccm.searchmusic.util.rememberFlowWithLifecycle

@Composable
fun SearchList(
    viewModel: MusicViewModel
) {
    val viewState by rememberFlowWithLifecycle(viewModel.state).collectAsState(initial = MusicUiState.Empty)

    // TODO: handle errors

    SearchListContent(
        viewModel,
        viewState,
        onPlayMusic = {
            viewModel.submitAction(SearchAction.PlayMusic(it))
        }
    )
}

@Composable
private fun SearchListContent(
    viewModel: MusicViewModel,
    viewState: MusicUiState,
    onPlayMusic: (Music) -> Unit
) {
    val musics = (viewState as? MusicUiState)?.data ?: mutableListOf()
    BoxWithConstraints {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(Modifier.height(1.dp))
            }

            items(musics) {
                MusicRowItem(viewModel, it, onPlayMusic)
            }
        }
    }
}

@Composable
fun MusicRowItem(
    viewModel: MusicViewModel,
    music: Music,
    onItemClicked: (item: Music) -> Unit
) {
    val currentMusic = viewModel.currentMusic.observeAsState().value
    val isPlaying = currentMusic == music

    ListViewItem(
        music = music, isPlaying = isPlaying,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onItemClicked(music)
            }
    )
}

@Composable
fun ListViewItem(
    music: Music,
    isPlaying: Boolean = false,
    modifier: Modifier
) {
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            music.artworkUrl100?.let {
                MusicThumb(it, isPlaying)
            }
            MusicDesc(music = music)
        }
    }
}

@Composable
fun MusicThumb(imagePath: String, isPlaying: Boolean = false) {
    Box {
        CoverImage(
            url = imagePath
        )
        if (isPlaying) {
            PlayIcon()
        }
    }
}

@Composable
fun MusicDesc(music: Music) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp)
    ) {
        Text(
            text = music.trackName.orEmpty()
        )
        Text(
            text = music.artistName.orEmpty(),
            style = MaterialTheme.typography.body1
        )
    }
}
