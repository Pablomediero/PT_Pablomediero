package com.example.pruebatecnica.pablomediero.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.pruebatecnica.pablomediero.core.composables.CustomCircleImage
import com.example.pruebatecnica.pablomediero.core.composables.CustomNavigationComponent
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        HeaderHomeScreen(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        )
        BodyHomeScreen(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(
                    top = PTpmedieroTheme.dimens.dimens10,
                    start = PTpmedieroTheme.dimens.dimens10
                )
                .fillMaxSize()
        )
    }

}

@Composable
fun HeaderHomeScreen(modifier: Modifier) {
    CustomNavigationComponent(
        modifier = modifier,
        startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
        text = stringResource(id = PTpmedieroTheme.strings.contacts),
        trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions)
    )
}

@Composable
fun BodyHomeScreen(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        LazyColumn {
            items(5) { user ->
                ItemUser()
            }
        }
    }
}

@Composable
private fun ItemUser() {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = PTpmedieroTheme.dimens.dimens8)
    ) {
        Column(
            modifier = Modifier.padding(end = PTpmedieroTheme.dimens.dimens10)
        ) {
            CustomCircleImage(
                painter = painterResource(PTpmedieroTheme.icons.iconPerson),
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
            )
        }
        Column(
            Modifier.padding(top = PTpmedieroTheme.dimens.dimens4)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        text = "Nombre ",
                        style = PTpmedieroTheme.types.typography.titleSmall,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(PTpmedieroTheme.dimens.dimens4))
                    Text(
                        text = "userEmail@email.com",
                        style = PTpmedieroTheme.types.typography.labelSmall,
                        color = PTpmedieroTheme.colors.ThemeSecondaryLight
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowRight),
                    contentDescription = "Icon Arrow Right",
                    tint = PTpmedieroTheme.colors.ThemeSecondaryLight
                )

            }
            Row {
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = PTpmedieroTheme.dimens.dimens20)
                        .fillMaxWidth()
                        .height(1.dp)
                )
            }
        }
    }
}

@ThemePreviews
@Composable
private fun PreviewHomeScreen() {
    MaterialTheme {
        HomeScreen()
    }
}