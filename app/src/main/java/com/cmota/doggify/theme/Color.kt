package com.cmota.doggify.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val colorPrimary = Color(0xFF121212)
val colorPrimaryTransparency = Color(0xDE121212)
val colorPrimaryTransparency20 = Color(0x40121212)
val colorAccent = Color(0xFFFFFFFF)
val colorSecondary = Color(0xFF03DAC5)
val colorSecondaryTransparency = Color(0x8003DAC5)
val colorFavorite = Color(0xFFCF6679)
val colorAccentSecondary = Color(0xFF9E9E9E)
val colorSurface = Color(0xFF2F2F2F)
val colorButton = Color(0xFFFFFFFF)
val colorBorder = Color(0xFF6200EE)

val doggifyColorScheme= Colors(
    primary = colorPrimary,
    primaryVariant = colorAccent,

    secondary = colorSecondary,
    secondaryVariant = colorAccent,

    background = colorPrimary,
    surface = colorSurface,

    error = colorFavorite,

    onPrimary = colorPrimaryTransparency,
    onSecondary = colorAccent,

    onBackground = colorPrimary,
    onSurface = colorPrimary,
    onError = colorAccent,

    isLight = false
)
