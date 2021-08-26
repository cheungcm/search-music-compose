package com.ccm.searchmusic.data.api

import com.ccm.searchmusic.Constants
import com.ccm.searchmusic.data.model.music.MusicResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET("search")
    suspend fun searchMusics(
        @Query("term") term: String = "",
        @Query("media") media: String = "music",
        @Query("limit") limit: Int
    ): MusicResponse

    companion object {
        fun create(): MusicService {
            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(MusicService::class.java)
        }
    }
}
