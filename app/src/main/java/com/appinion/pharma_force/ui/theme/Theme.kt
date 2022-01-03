package com.appinion.pharma_force.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @author MD. Masum Taluker
 * dark and light theme setting globally
 */
private val DarkColorPalette = darkColors(
    primary = White,
    primaryVariant = BlueMedium,
    secondary = BlueMedium
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = BlueMedium,
    secondary = BlueMedium

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

/**
 * @name theme called as  PharmaForceTheme
 * use it as a custom theme
 * for getting custom behaviour
 * in appUI
 */
@Composable
fun PharmaForceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
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