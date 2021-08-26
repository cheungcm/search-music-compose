/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccm.searchmusic.data.model.music.Music
import com.ccm.searchmusic.player.AudioPlayer
import com.ccm.searchmusic.ui.music.model.MusicNetworkState
import com.ccm.searchmusic.ui.music.model.MusicUiState
import com.ccm.searchmusic.ui.music.model.SearchAction
import com.ccm.searchmusic.ui.music.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

const val SEARCH_DEBOUNCE_MILLIS = 400L

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val audioPlayer: AudioPlayer
) : ViewModel() {

    private val initialQuery = ""
    private val searchQuery = MutableStateFlow(initialQuery)
    private val pendingActions = MutableSharedFlow<SearchAction>()
    val currentMusic = MutableLiveData<Music?>()
    private val uiState = MutableStateFlow(MusicUiState.Empty)
    val state = uiState

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is SearchAction.QueryChange -> {
                        searchQuery.value = action.query
                    }
                    is SearchAction.PlayMusic -> {
                        playMusic(action.music)
                        currentMusic.value = action.music
                    }
                    else -> {
                        // TODO
                    }
                }
            }
        }

        viewModelScope.launch {
            searchQuery
                .debounce(SEARCH_DEBOUNCE_MILLIS)
                .filter { query ->
                    return@filter query.trim().isNotEmpty()
                }
                .distinctUntilChanged()
                .collectLatest {
                    searchMusics(it)
                }
        }
    }

    fun submitAction(action: SearchAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    // Set limit to 15 for demo purpose
    private fun searchMusics(query: String, limit: Int = 15) {
        viewModelScope.launch {
            musicRepository.getMusics(query, limit)
                .collect { state ->
                    when (state) {
                        is MusicNetworkState.Success -> {
                            uiState.value = MusicUiState(data = state.data)
                        }
                        is MusicNetworkState.Failure -> {
                            uiState.value = MusicUiState(error = state.exception)
                        }
                    }
                }
        }
    }

    private fun playMusic(music: Music) {
        if (music.previewUrl.isNullOrEmpty()) {
            return
        }
        viewModelScope.launch {
            audioPlayer.apply {
                setSource(Uri.parse(music.previewUrl))
                prepare()
                play()
            }
        }
    }
}
