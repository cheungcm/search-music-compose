/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.di

import android.content.Context
import com.ccm.searchmusic.player.AudioPlayer
import com.ccm.searchmusic.player.AudioPlayerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAudioPlayer(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient,
    ): AudioPlayer {
        return AudioPlayerImpl(context, okHttpClient)
    }
}
