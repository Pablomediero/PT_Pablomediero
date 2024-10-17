package com.example.pruebatecnica.pablomediero.presentation.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.pruebatecnica.pablomediero.core.composables.CustomCircleImage
import com.example.pruebatecnica.pablomediero.core.composables.CustomNavigationComponent
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme

@Composable
fun DetailScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        CustomCircleImage(
            modifier = Modifier
                .size(90.dp)
                .offset(x = 20.dp, y = 110.dp)
                .zIndex(1f)
                .border(5.dp, Color.Gray, CircleShape),

            painter = painterResource(id = PTpmedieroTheme.icons.iconPerson)
        )
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ) {
            HeaderDetailScreen(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f)
            )

            BodyDetailScreen(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize()
            )

        }

    }

}

@Composable
fun HeaderDetailScreen(modifier: Modifier) {
    Column (modifier = modifier) {
        CustomNavigationComponent(
            modifier = Modifier.fillMaxWidth(),
            startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
            text = stringResource(id = PTpmedieroTheme.strings.username),
            trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions)
        )
    }
}


@Composable
fun BodyDetailScreen(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconPhoto),
                    contentDescription = "Icon More Actions"
                )
            }
            Spacer(Modifier.width(PTpmedieroTheme.dimens.dimens4))
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconEdit),
                    contentDescription = "Icon More Actions"
                )
            }
        }
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPerson),
            title = "Nombre y apellidos",
            subTitle = "Nombre"
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPersonEmail),
            title = "Email",
            subTitle = "Nombre"
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPersonGender),
            title = "Género",
            subTitle = "Nombre"
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconDateRegister),
            title = "Nombre",
            subTitle = "Nombre"
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPhone),
            title = "Nombre",
            subTitle = "Nombre"
        )
    }
}

@Composable
private fun InformationComponent(
    startIcon: Painter,
    title: String,
    subTitle: String,
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = PTpmedieroTheme.dimens.dimens10)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = PTpmedieroTheme.dimens.dimens30, vertical = PTpmedieroTheme.dimens.dimens10)
        ) {
            CustomCircleImage(
                painter = startIcon,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)

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
                        text = title,
                        style = PTpmedieroTheme.types.typography.labelSmall,
                        color = PTpmedieroTheme.colors.ThemeSecondaryLight
                    )
                    Spacer(modifier = Modifier.height(PTpmedieroTheme.dimens.dimens8))
                    Text(
                        text = subTitle,
                        style = PTpmedieroTheme.types.typography.titleSmall,
                        color = Color.Black
                    )
                }

            }
            Row {
                HorizontalDivider(
                    modifier = Modifier
                        .padding(top = PTpmedieroTheme.dimens.dimens8)
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
        DetailScreen()
    }
}