package com.example.pruebatecnica.pablomediero.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.LocalPTpmedieroColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.colors.PTpmedieroColors
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.LocalPTpmedieroDimens
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PtpmedieroDimens
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.LocalPTpmedieroStrings
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStrings
import com.example.pruebatecnica.pablomediero.core.ui.theme.types.LocalPTpmedieroTypes
import com.example.pruebatecnica.pablomediero.core.ui.theme.types.PTpmedieroTypes


@Composable
fun PruebaTecnicaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if(!darkTheme){
        PTpmedieroTheme.colors.lightColors
    }else{
        PTpmedieroTheme.colors.darkColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PTpmedieroTheme.types.typography,
        content = content
    )
}

object PTpmedieroTheme {

    val types : PTpmedieroTypes @Composable get() = LocalPTpmedieroTypes.current
    val colors : PTpmedieroColors @Composable get() = LocalPTpmedieroColors.current
    val dimens : PtpmedieroDimens @Composable get() = LocalPTpmedieroDimens.current
    val strings : PTpmedieroStrings @Composable get() = LocalPTpmedieroStrings.current
}