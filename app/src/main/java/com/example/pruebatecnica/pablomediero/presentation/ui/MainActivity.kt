package com.example.pruebatecnica.pablomediero.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme
import com.example.pruebatecnica.pablomediero.core.ui.theme.PruebaTecnicaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaTecnicaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (
        Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = stringResource(PTpmedieroTheme.strings.testTitle) ,
            modifier = modifier
        )
        Text(
            text = stringResource(PTpmedieroTheme.strings.testDescription) ,
            modifier = modifier
        )

    }
}

@ThemePreviews
@Composable
fun GreetingPreview() {
    PruebaTecnicaTheme {
        Greeting(stringResource(PTpmedieroTheme.strings.testDescription))
    }
}