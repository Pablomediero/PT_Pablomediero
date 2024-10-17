package com.example.pruebatecnica.pablomediero.core.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme


@Composable
fun CustomNavigationComponent(
    modifier: Modifier,
    startIcon: ImageVector,
    text: String,
    trailIcon: ImageVector
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(

            onClick = { }
        ) {
            Icon(
                modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                imageVector = startIcon,
                contentDescription = "Icon Arrow Back"
            )
        }
        Column(
            modifier = Modifier.weight(3f),

            ) {
            Text(
                text = text,
                style = PTpmedieroTheme.types.typography.titleMedium
            )
        }
        IconButton(
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                imageVector = trailIcon,
                contentDescription = "Icon More Actions"
            )
        }
    }
}

@ThemePreviews
@Composable
private fun PreviewCustomNavigationComponent() {
    CustomNavigationComponent(
        Modifier.fillMaxWidth(),
        startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
        text = stringResource(id = PTpmedieroTheme.strings.contacts),
        trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions)
    )
}