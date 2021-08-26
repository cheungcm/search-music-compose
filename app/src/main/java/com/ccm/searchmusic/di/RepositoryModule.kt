package com.ccm.searchmusic.di

import com.ccm.searchmusic.data.api.MusicService
import com.ccm.searchmusic.ui.music.repository.MusicRepository
import com.ccm.searchmusic.ui.music.repository.MusicRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideHomeRepository(
        service: MusicService
    ): MusicRepository {
        return MusicRepositoryImpl(service)
    }
}
