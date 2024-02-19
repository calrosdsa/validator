package app.validator.presentation.ui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF476810)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFC7F089)
// ..
// ..

val md_theme_dark_primary = Color(0xFFACD370)
val md_theme_dark_onPrimary = Color(0xFF213600)
val md_theme_dark_primaryContainer = Color(0xFF324F00)

internal val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
)
internal val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
)