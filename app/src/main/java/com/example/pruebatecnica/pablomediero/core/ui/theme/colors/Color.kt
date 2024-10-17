package com.example.pruebatecnica.pablomediero.core.ui.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkBackground
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkOnBackground
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkOnPrimary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkOnSurface
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkPrimary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkSecondary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkSurface
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightBackground
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightOnBackground
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightOnPrimary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightOnSurface
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightPrimary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightSecondary
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightSurface


private object PTPmedieroColorDefaults {
    val Purple80 = Color(0xFFD0BCFF)
    val PurpleGrey80 = Color(0xFFCCC2DC)
    val Pink80 = Color(0xFFEFB8C8)

    val Purple40 = Color(0xFF6650a4)
    val PurpleGrey40 = Color(0xFF625b71)
    val Pink40 = Color(0xFF7D5260)

    val LightPrimary = Color.Black
    val LightOnPrimary = Color.White
    val LightBackground = Color.White
    val LightOnBackground = Color.Black
    val LightSurface = Color.White
    val LightOnSurface = Color.Black
    val LightSecondary = Color.Gray

    val DarkPrimary = Color.White
    val DarkOnPrimary = Color.Black
    val DarkBackground = Color.Black
    val DarkOnBackground = Color.White
    val DarkSurface = Color.DarkGray
    val DarkOnSurface = Color.White
    val DarkSecondary = Color.LightGray

    val LightColors = lightColorScheme(
        primary = LightPrimary,
        onPrimary = LightOnPrimary,
        background = LightBackground,
        onBackground = LightOnBackground,
        surface = LightSurface,
        onSurface = LightOnSurface,
        secondary = LightSecondary
    )

    val DarkColors = darkColorScheme(
        primary = DarkPrimary,
        onPrimary = DarkOnPrimary,
        background = DarkBackground,
        onBackground = DarkOnBackground,
        surface = DarkSurface,
        onSurface = DarkOnSurface,
        secondary = DarkSecondary
    )
}

@Immutable
data class PTpmedieroColors(
    val ThemePrimaryLight: Color = LightPrimary,
    val ThemeOnPrimaryLight: Color = LightOnPrimary,
    val ThemeBackgroundLight: Color = LightBackground,
    val ThemeOnBackgroundLight: Color = LightOnBackground,
    val ThemeSurfaceLight: Color = LightSurface,
    val ThemeOnSurfaceLight: Color = LightOnSurface,
    val ThemeSecondaryLight: Color = LightSecondary,

    val ThemePrimaryDark: Color = DarkPrimary,
    val ThemeOnPrimaryDark: Color = DarkOnPrimary,
    val ThemeBackgroundDark: Color = DarkBackground,
    val ThemeOnBackgroundDark: Color = DarkOnBackground,
    val ThemeSurfaceDark: Color = DarkSurface,
    val ThemeOnSurfaceDark: Color = DarkOnSurface,
    val ThemeSecondaryDark: Color = DarkSecondary,

    val lightColors: ColorScheme = LightColors,
    val darkColors: ColorScheme = DarkColors
)

internal val LocalPTpmedieroColors = staticCompositionLocalOf { PTpmedieroColors() }
