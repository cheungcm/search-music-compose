package com.ccm.searchmusic.di

import com.ccm.searchmusic.data.api.MusicService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideMusicService(): MusicService {
        return MusicService.create()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}
