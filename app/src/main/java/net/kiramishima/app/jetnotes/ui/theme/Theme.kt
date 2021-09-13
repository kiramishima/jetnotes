package net.kiramishima.app.jetnotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.kiramishima.app.jetnotes.theme.JetNotesThemeSettings
import net.kiramishima.app.jetnotes.theme.rwGreen
import net.kiramishima.app.jetnotes.theme.rwGreenDark
import net.kiramishima.app.jetnotes.theme.rwRed

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

private val LightThemeColors = lightColors(
    primary = rwGreen,
    primaryVariant = rwGreenDark,
    secondary = rwRed
)

private val DarkThemeColors = darkColors(
    primary = Color(0xFF00A055),
    primaryVariant = Color(0xFF00F884),
    secondary = rwRed,
    onPrimary = Color.White
)

@Composable
fun JetNotesTheme(content: @Composable() () -> Unit) {
    val isDarkThemeEnabled =
        isSystemInDarkTheme() ||
                JetNotesThemeSettings.isDarkThemeEnabled

    val colors = if (isDarkThemeEnabled) {
        DarkThemeColors
    } else {
        LightThemeColors
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}