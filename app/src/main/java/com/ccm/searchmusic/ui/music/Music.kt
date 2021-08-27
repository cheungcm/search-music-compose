/*
 * Copyright (C) 2021, Ryan Cheung
 * All rights reserved.
 */
package com.ccm.searchmusic.ui.music

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccm.searchmusic.R
import com.ccm.searchmusic.ui.music.model.SearchAction
import com.ccm.common.ui.theme.Padding
import com.ccm.common.ui.theme.PaddingSmall
import com.ccm.common.ui.theme.PaddingTiny
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun Music() {
    Music(viewModel = hiltViewModel())
}

@Composable
internal fun Music(
    viewModel: MusicViewModel,
) {
    Music(viewModel) { action ->
        viewModel.submitAction(action)
    }
}

@Composable
internal fun Music(
    viewModel: MusicViewModel,
    actioner: (SearchAction) -> Unit
) {
    Music(actioner, viewModel)
}

@Composable
private fun Music(
    actioner: (SearchAction) -> Unit,
    viewModel: MusicViewModel
) {
    val searchBarHeight = 200.dp
    val searchBarOffset = remember { Animatable(0f) }

    Scaffold(
        topBar = {
            SearchAppBar(
                modifier = Modifier
                    .graphicsLayer {
                        alpha = 1 - searchBarOffset.value
                        translationY = searchBarHeight.value * (-searchBarOffset.value)
                    },
                onQueryChange = { actioner(SearchAction.QueryChange(it)) },
                onSearch = { actioner(SearchAction.Search) },
            )
        }
    ) {
        SearchList(
            viewModel = viewModel
        )
    }
}

@Composable
@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
private fun SearchAppBar(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit = {},
    onSearch: () -> Unit = {},
) {
    val initialQuery = ""

    Box(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(bottom = PaddingTiny)
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current

        val triggerSearch = {
            onSearch()
            keyboardController?.hide()
            focusManager.clearFocus()
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(PaddingSmall),
            modifier = Modifier.animateContentSize()
        ) {
            Spacer(modifier = Modifier.height(Padding))

            var query by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(
                    TextFieldValue(initialQuery)
                )
            }
            SearchTextField(
                value = query,
                onValueChange = { value ->
                    query = value
                    onQueryChange(value.text)
                },
                onSearch = { triggerSearch() },
                hint = stringResource(R.string.search_hint),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun SearchTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    onSearch: () -> Unit = {},
    hint: String,
    maxLength: Int = 50,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search, keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(onSearch = { onSearch() }),
) {
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.text.length <= maxLength) onValueChange(it) },
        placeholder = { Text(text = hint) },
        trailingIcon = {
            IconButton(
                onClick = {
                    onValueChange(TextFieldValue())
                },
            ) {
                Icon(
                    tint = MaterialTheme.colors.secondary,
                    imageVector = Icons.Default.Clear,
                    contentDescription = stringResource(R.string.clear)
                )
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        maxLines = 1,
        visualTransformation = { text -> TransformedText(text.capitalize(), OffsetMapping.Identity) },
        modifier = modifier
            .padding(horizontal = Padding)
    )
}
