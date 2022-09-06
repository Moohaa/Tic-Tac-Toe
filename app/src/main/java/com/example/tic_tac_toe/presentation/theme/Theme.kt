package com.example.tic_tac_toe.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = blue0,
    primaryVariant = blue1,
    secondary = blue3,
    background = blue0,
    surface = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
)

private val LightColorPalette = lightColors(
    primary = blue1,
    primaryVariant = blue2,
    secondary = blue3,

    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)
@Composable
fun Tic_Tac_ToeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}