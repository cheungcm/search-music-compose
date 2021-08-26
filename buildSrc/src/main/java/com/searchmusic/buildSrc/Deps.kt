package com.searchmusic.buildSrc

object Deps {

    object Android {

        object Compose {
            const val version = "1.0.0"
            const val navigationVersion = "2.4.0-alpha03"
            const val activityVersion = "1.3.1"

            const val runtime = "androidx.compose.runtime:runtime:1.0.0-beta09"
            const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val materialDesign = "androidx.compose.material:material:$version"
            const val materialDesignIcons = "androidx.compose.material:material-icons-core:$version"
            const val materialDesignIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02"
            const val activity = "androidx.activity:activity-compose:$activityVersion"
            const val viewModels = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
            const val paging = "androidx.paging:paging-compose:1.0.0-alpha12"
        }
    }
}
