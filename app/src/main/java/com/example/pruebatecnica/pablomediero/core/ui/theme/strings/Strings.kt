package com.example.pruebatecnica.pablomediero.core.ui.theme.strings

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.pruebatecnica.pablomediero.R
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.Contacts
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.CustomDialogErrorConnectionDescription
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.CustomDialogErrorConnectionTitle
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.CustomDialogErrorUnknownDescription
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.CustomDialogErrorUnknownTitle
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestDescription
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.TestTitle
import com.example.pruebatecnica.pablomediero.core.ui.theme.strings.PTpmedieroStringsDefaults.Username

private object PTpmedieroStringsDefaults {
    val TestTitle = R.string.test_title
    val TestDescription = R.string.test_desc
    val Contacts = R.string.contacts
    val Username = R.string.username
    val CustomDialogErrorConnectionTitle = R.string.custom_dialog_error_no_connection_error_code_title
    val CustomDialogErrorConnectionDescription = R.string.custom_dialog_error_no_connection_error_code_description
    val CustomDialogErrorUnknownTitle = R.string.custom_dialog_error_no_connection_error_code_title
    val CustomDialogErrorUnknownDescription = R.string.custom_dialog_error_no_connection_error_code_description

}

@Immutable
data class PTpmedieroStrings(
    @StringRes val testTitle: Int = TestTitle,
    @StringRes val testDescription: Int = TestDescription,
    @StringRes val contacts: Int = Contacts,
    @StringRes val username: Int = Username,
    @StringRes val customDialogErrorConnectionCodeTitle: Int = CustomDialogErrorConnectionTitle,
    @StringRes val customDialogErrorConnectionCodeDescription: Int = CustomDialogErrorConnectionDescription,
    @StringRes val customDialogErrorUnknownCodeTitle: Int = CustomDialogErrorUnknownTitle,
    @StringRes val customDialogErrorUnknownCodeDescription: Int = CustomDialogErrorUnknownDescription
)

internal val LocalPTpmedieroStrings= staticCompositionLocalOf { PTpmedieroStrings() }
