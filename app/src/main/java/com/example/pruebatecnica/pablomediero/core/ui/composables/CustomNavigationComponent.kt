package com.example.pruebatecnica.pablomediero.core.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme

@Composable
fun CustomNavigationComponentWithSearch(
    modifier: Modifier,
    startIcon: ImageVector,
    trailIcon: ImageVector,
    startIconColor: Color = PTpmedieroTheme.colors.ThemePrimaryDark,
    trailIconColor: Color = PTpmedieroTheme.colors.ThemePrimaryDark,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    onStartIconClick: () -> Unit,
    onTrailIconClick: () -> Unit
) {
    Row(
        modifier = modifier.height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { onStartIconClick() }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = startIcon,
                    contentDescription = "Icon Arrow Back",
                    tint = startIconColor
                )
            }
        }
        Column(
            modifier = Modifier.weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                value = value,
                onValueChange = onValueChange,
                placeholder = { Text(placeholder, style = PTpmedieroTheme.types.typography.labelLarge.copy(Color.Black))},
                singleLine = true,
                textStyle = PTpmedieroTheme.types.typography.labelLarge.copy(color = Color.Black),
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconSearch) ,
                        contentDescription = "Buscar",
                        modifier = Modifier.size(24.dp)
                    )
                }
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = {
                    onTrailIconClick()
                }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = trailIcon,
                    contentDescription = "Icon More Actions",
                    tint = trailIconColor
                )
            }
        }
    }
}

@Composable
fun CustomNavigationComponent(
    modifier: Modifier,
    startIcon: ImageVector,
    startIconColor: Color = PTpmedieroTheme.colors.ThemePrimaryDark,
    text: String,
    textColor: Color = PTpmedieroTheme.colors.ThemePrimaryDark,
    trailIcon: ImageVector,
    trailIconColor: Color = PTpmedieroTheme.colors.ThemePrimaryDark,
    onStartIconClick: () -> Unit,
    onTrailIconClick: () -> Unit
) {
    Row(
        modifier = modifier.height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            IconButton(
                onClick = { onStartIconClick() }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = startIcon,
                    contentDescription = "Icon Arrow Back",
                    tint = startIconColor
                )
            }
        }
        Column(
            modifier = Modifier.weight(3f),
        ) {
            Text(
                text = text,
                style = PTpmedieroTheme.types.typography.titleMedium.copy(color = textColor)
            )
        }
        Column {
            IconButton(
                onClick = {
                    onTrailIconClick()
                }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = trailIcon,
                    contentDescription = "Icon More Actions",
                    tint = trailIconColor
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCustomNavigationComponent() {
    CustomNavigationComponent(
        Modifier.fillMaxWidth(),
        startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
        text = stringResource(id = PTpmedieroTheme.strings.username),
        trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions),
        onStartIconClick = {},
        onTrailIconClick = {},
    )
}
@Preview
@Composable
private fun PreviewCustomNavigationComponentWithSearch() {
    CustomNavigationComponentWithSearch (
        Modifier.fillMaxWidth(),
        startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
        trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions),
        value = "Prueba",
        placeholder = "",
        onStartIconClick = {},
        onTrailIconClick = {},
        onValueChange = {}
    )
}