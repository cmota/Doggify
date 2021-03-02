package com.cmota.doggify.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmota.doggify.R
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun DetailsTopAppBar(onBack: () -> Unit) {
    val statusBarPaddingTop = LocalWindowInsets.current
        .statusBars
        .toPaddingValues()
        .calculateTopPadding()

    TopAppBar(
        title = { },
        backgroundColor = Color.Transparent,
        contentColor = MaterialTheme.colors.primaryVariant,
        navigationIcon = {
            val menu = painterResource(R.drawable.ic_back)
            IconButton(onClick = {
                onBack()
            }) {
                Icon(menu, stringResource(id = R.string.description_back))
            }
        },
        modifier = Modifier.padding(top = statusBarPaddingTop),
        elevation = 0.dp
    )
}