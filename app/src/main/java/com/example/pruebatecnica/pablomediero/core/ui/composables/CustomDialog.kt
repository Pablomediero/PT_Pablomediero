package com.example.pruebatecnica.pablomediero.core.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.data.datasources_core.HttpErrorCodeException
import com.example.pruebatecnica.pablomediero.data.datasources_core.HttpErrorCodeException.Companion.NO_CONNECTION_ERROR_CODE
import com.example.pruebatecnica.pablomediero.data.datasources_core.HttpErrorCodeException.Companion.UNKNOWN_ERROR_CODE

@Composable
fun CustomDialog(
    showDialog: Boolean,
    uiState: UIState<*>,
    onDismiss: () -> Unit
) {
    if (showDialog && uiState is UIState.Error) {
        var title by rememberSaveable { mutableStateOf("") }
        var description by rememberSaveable { mutableStateOf("") }

        when( uiState.exception) {
            is HttpErrorCodeException -> {
                val (errorTitle, descriptionTitle) = manageErrorCode(uiState.exception.errorCode)
                title = stringResource(id = errorTitle)
                description = stringResource(id = descriptionTitle)
            }
        }
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = description)
            },
            confirmButton = {
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismiss() }
                ) {
                    Text("Ok")
                }
            }
        )
    }
}

@Composable
fun manageErrorCode(errorCode: Int): Pair<Int, Int> {
    var title = PTpmedieroTheme.strings.testTitle
    var description = PTpmedieroTheme.strings.testDescription
    when (errorCode) {
        NO_CONNECTION_ERROR_CODE -> {
            title = PTpmedieroTheme.strings.customDialogErrorConnectionCodeTitle
            description = PTpmedieroTheme.strings.customDialogErrorConnectionCodeDescription
        }

        UNKNOWN_ERROR_CODE -> {
            title = PTpmedieroTheme.strings.customDialogErrorUnknownCodeTitle
            description = PTpmedieroTheme.strings.customDialogErrorUnknownCodeDescription

        }
    }
    return Pair(title, description)

}
