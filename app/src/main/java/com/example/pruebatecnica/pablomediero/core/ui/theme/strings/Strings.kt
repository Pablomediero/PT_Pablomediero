package com.example.pruebatecnica.pablomediero.core.ui.theme.strings

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.pruebatecnica.pablomediero.R
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestDescription
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestTitle

private object PTpmedieroStringsDefaults {
    val TestTitle = R.string.test_title
    val TestDescription = R.string.test_desc
}

@Immutable
data class PTpmedieroStrings(
    @StringRes val testTitle: Int = TestTitle,
    @StringRes val testDescription: Int = TestDescription
)

internal val LocalPTpmedieroStrings= staticCompositionLocalOf { PTpmedieroStrings() }
