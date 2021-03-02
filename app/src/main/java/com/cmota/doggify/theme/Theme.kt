package com.cmota.doggify.theme

import android.view.View
import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb

@Composable
fun DoggifyTheme(window: Window, content: @Composable () -> Unit) {

    window.statusBarColor = colorPrimaryTransparency20.toArgb()

    @Suppress("DEPRECATION")
    window.decorView.systemUiVisibility = window.decorView.systemUiVisibility and
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()


    MaterialTheme(
        colors = doggifyColorScheme,
        typography = typography,
        content = content
    )
}