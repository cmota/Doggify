package com.cmota.doggify.main

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmota.doggify.R

@Composable
fun MainTopAppBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.primaryVariant,
        navigationIcon = {
            val menu = painterResource(R.drawable.ic_menu)
            IconButton(onClick = {
                //bottomSheetScaffoldState.bottomSheetState.expand()
            }) {
                Icon(menu, stringResource(id = R.string.description_menu))
            }
        },
        actions = {
            val search = painterResource(R.drawable.ic_search)
            IconButton(onClick = {
                Toast.makeText(context, R.string.toast_not_available, Toast.LENGTH_SHORT).show()
            }) {
                Image(search, stringResource(id = R.string.description_search))
            }
        },
        elevation = 0.dp
    )
}