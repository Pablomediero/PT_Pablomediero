package com.example.pruebatecnica.pablomediero.core.ui.theme.strings

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.pruebatecnica.pablomediero.R
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.Contacts
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestDescription
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestTitle
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.Username

private object PTpmedieroStringsDefaults {
    val TestTitle = R.string.test_title
    val TestDescription = R.string.test_desc
    val Contacts = R.string.contacts
    val Username = R.string.username

}

@Immutable
data class PTpmedieroStrings(
    @StringRes val testTitle: Int = TestTitle,
    @StringRes val testDescription: Int = TestDescription,
    @StringRes val contacts: Int = Contacts,
    @StringRes val username: Int = Username
)

internal val LocalPTpmedieroStrings= staticCompositionLocalOf { PTpmedieroStrings() }
