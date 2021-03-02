package com.cmota.doggify.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cmota.doggify.R

val fontSizeLarge = 36.sp
val fontSizeMedium = 14.sp
val fontSizeSmall = 14.sp

private val RobotoFontFamily = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular)
)

val typography = Typography(
    h1 = TextStyle(
        color = colorAccent,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = fontSizeLarge
    ),

    h2 = TextStyle(
        color = colorSecondary,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = fontSizeLarge,
    ),

    body1 = TextStyle(
        color = colorAccent,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = fontSizeMedium,
    ),

    body2 = TextStyle(
        color = colorPrimary,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = fontSizeMedium,
    ),


    subtitle1 = TextStyle(
        color = colorAccent,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = fontSizeSmall,
    ),

    subtitle2 = TextStyle(
        color = colorAccentSecondary,
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = fontSizeSmall,
    ),
)