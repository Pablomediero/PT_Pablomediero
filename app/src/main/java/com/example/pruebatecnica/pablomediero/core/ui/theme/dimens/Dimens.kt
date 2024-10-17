package com.example.pruebatecnica.pablomediero.core.ui.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens10
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens100
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens20
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens200
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens30
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens4
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens50
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens6
import com.example.pruebatecnica.pablomediero.core.ui.theme.dimens.PTpmedieroDimensDefaults.Dimens8

private object PTpmedieroDimensDefaults {
    val Dimens4: Dp = 4.dp
    val Dimens6: Dp = 6.dp
    val Dimens8: Dp = 8.dp
    val Dimens10: Dp = 10.dp
    val Dimens20: Dp = 20.dp
    val Dimens30: Dp = 30.dp
    val Dimens50: Dp = 50.dp
    val Dimens100: Dp = 100.dp
    val Dimens200: Dp = 200.dp
}

@Immutable
data class PtpmedieroDimens(
    val dimens4: Dp = Dimens4,
    val dimens6: Dp = Dimens6,
    val dimens8: Dp = Dimens8,
    val dimens10: Dp = Dimens10,
    val dimens20: Dp = Dimens20,
    val dimens30: Dp = Dimens30,
    val dimens50: Dp = Dimens50,
    val dimens100: Dp = Dimens100,
    val dimens200: Dp = Dimens200,
)

internal val LocalPTpmedieroDimens= staticCompositionLocalOf { PtpmedieroDimens() }
