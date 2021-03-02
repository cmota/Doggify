package com.cmota.doggify.details

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cmota.doggify.model.DoggoItem
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun DetailsScreen(doggo: DoggoItem, onBack: () -> Unit, onClick: () -> Unit) {

    val navigationPaddingBottom = LocalWindowInsets.current
        .navigationBars
        .toPaddingValues()
        .calculateBottomPadding()

    Scaffold(
        floatingActionButton = {
            AddContactAction(onClick = { onClick })
        },
        content = {
            DetailsItem(doggo = doggo)

            DetailsTopAppBar(onBack = onBack)
        },
        modifier = Modifier.padding(bottom = navigationPaddingBottom),
    )
}