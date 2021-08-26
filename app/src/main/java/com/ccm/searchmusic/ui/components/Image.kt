package com.ccm.searchmusic.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import com.ccm.searchmusic.R
import com.ccm.searchmusic.ui.theme.ThumbSize

@Composable
fun CoverImage(
    url: String,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(ThumbSize)
    )
}

@Composable
fun PlayIcon(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberImagePainter(R.drawable.ic_pause),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.size(ThumbSize)
    )
}