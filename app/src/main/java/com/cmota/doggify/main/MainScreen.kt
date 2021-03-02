package com.cmota.doggify.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.cmota.doggify.MainViewModel
import com.cmota.doggify.model.DoggoItem

@ExperimentalFoundationApi
@Composable
fun MainScreen(viewModel: MainViewModel, openDetails: (doggo: DoggoItem) -> Unit) {

    Scaffold(
        topBar = {
            MainTopAppBar()
        },
        content = {
            MainScreenItems(viewModel = viewModel, openDetails = openDetails)
        }
    )
}