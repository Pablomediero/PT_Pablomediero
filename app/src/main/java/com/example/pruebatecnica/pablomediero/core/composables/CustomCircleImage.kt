package com.example.pruebatecnica.pablomediero.core.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme


@Composable
fun CustomCircleImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentScale: ContentScale
) {
    Column (
        modifier = modifier

            .size(100.dp)
            .clip(CircleShape)
            .background(Color.White)

    ) {
        Image(
            painter = painter,
            contentDescription = "Profile Picture",
            contentScale = contentScale,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .padding(PTpmedieroTheme.dimens.dimens4)

        )
    }

}

@Preview
@Composable
private fun PreviewCustomCircleImage() {
    CustomCircleImage(
        painter = painterResource(PTpmedieroTheme.icons.iconPerson),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(1.dp, Color.Gray, CircleShape)
    )
}