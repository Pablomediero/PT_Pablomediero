package com.example.pruebatecnica.pablomediero.core.ui.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.DarkColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.LightColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.Pink40
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.Pink80
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.Purple40
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.Purple80
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.PurpleGrey40
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTPmedieroColorDefaults.PurpleGrey80


private object PTPmedieroColorDefaults {
    val Purple80 = Color(0xFFD0BCFF)
    val PurpleGrey80 = Color(0xFFCCC2DC)
    val Pink80 = Color(0xFFEFB8C8)

    val Purple40 = Color(0xFF6650a4)
    val PurpleGrey40 = Color(0xFF625b71)
    val Pink40 = Color(0xFF7D5260)


    val LightColors = lightColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        background = Pink80
    )

    val DarkColors = darkColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        background = Pink40
    )
}

@Immutable
data class PTpmedieroColors(
    val ThemePrimaryLight: Color = Purple80,
    val ThemeSecondaryLight: Color = PurpleGrey80,
    val ThemeBackgroundLight: Color = Pink80,
    val ThemePrimaryDark: Color = Purple40,
    val ThemeSecondaryDark: Color = PurpleGrey40,
    val ThemeBackgroundDark: Color = Pink40,

    val lightColors: ColorScheme = LightColors,
    val darkColors: ColorScheme = DarkColors
)

internal val LocalPTpmedieroColors = staticCompositionLocalOf { PTpmedieroColors() }
