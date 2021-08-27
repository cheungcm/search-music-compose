package com.searchmusic.buildSrc

object Deps {

    object Android {

        object Compose {
            private const val version = "1.0.0"
            private const val navigationVersion = "2.4.0-alpha03"

            const val ui = "androidx.compose.ui:ui:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val materialDesign = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:1.0.0-beta09"
            const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val viewModels = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        }
    }

    object Accompanist {
        private const val version = "0.16.1"

        const val insets = "com.google.accompanist:accompanist-insets:$version"
    }

    object Coil {
        private const val version = "1.3.2"

        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object Dagger {
        private const val version = "2.38.1"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object OkHttp {
        private const val version = "5.0.0-alpha.2"

        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logger = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Moshi {
        private const val version = "1.12.0"

        const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
        const val kotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object ExoPlayer {
        private const val version = "2.15.0"

        const val exoPlayer = "com.google.android.exoplayer:exoplayer-core:$version"
        const val exoPlayerOkhttp = "com.google.android.exoplayer:extension-okhttp:$version"
    }

    object Timber {
        private const val version = "5.0.1"

        const val timber = "com.jakewharton.timber:timber:$version"
    }
}
