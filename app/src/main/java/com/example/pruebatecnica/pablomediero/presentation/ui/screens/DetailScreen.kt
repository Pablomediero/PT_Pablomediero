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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.composables.CustomCircleImage
import com.example.pruebatecnica.pablomediero.core.ui.composables.CustomNavigationComponent
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.core.ui.utils.toFormattedDate
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.presentation.navigation.AppRoutes
import com.example.pruebatecnica.pablomediero.presentation.viewmodels.UserViewModel
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun DetailScreen(
    navController: NavController,
    email: String?,
    userViewModel: UserViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        userViewModel.getUserDetail(email ?: "")
    }

    val usersData by userViewModel.user.collectAsState()
    val user = remember { mutableStateOf<User?>(null) }
    val isLoading = remember { mutableStateOf(false) }

    when (val state = usersData) {
        UIState.Loading -> {
            isLoading.value = true
        }

        is UIState.Error -> {
            Timber.e("Error UI ${state.exception}")
            isLoading.value = false
        }

        is UIState.Success -> {
            state.data?.let {
                Timber.i("USUARIO: ${user.value}")
                user.value = it
            } ?: run {
                Timber.e("No se encontró ningún usuario.")
            }
            isLoading.value = false
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        CustomCircleImage(
            modifier = Modifier
                .size(90.dp)
                .offset(x = 20.dp, y = 165.dp)
                .zIndex(1f)
                .border(5.dp, MaterialTheme.colorScheme.background, CircleShape)
                .shadow(elevation = 0.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                model = user.value?.picture?.thumbnail ?: PTpmedieroTheme.icons.iconPerson
            )
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
                    .fillMaxHeight(0.25f),
                onStartIconClick = {
                    navController.navigate(AppRoutes.HomeScreen.route)
                }
            )

            user.value?.let {
                BodyDetailScreen(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize(),
                    user = it
                )
            } ?: run {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

        }

    }

}

@Composable
fun HeaderDetailScreen(modifier: Modifier, onStartIconClick: () -> Unit) {
    Column(modifier = modifier) {
        CustomNavigationComponent(
            modifier = Modifier.fillMaxWidth(),
            startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
            text = stringResource(id = PTpmedieroTheme.strings.username),
            trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions),
            onTrailIconClick = {},
            onStartIconClick = { onStartIconClick() }
        )
    }
}


@Composable
fun BodyDetailScreen(modifier: Modifier, user: User) {
    Column(
        modifier = modifier
    ) {
        Row(
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
                    contentDescription = "Icon Photo "
                )
            }
            Spacer(Modifier.width(PTpmedieroTheme.dimens.dimens4))
            IconButton(
                onClick = { }
            ) {
                Icon(
                    modifier = Modifier.size(PTpmedieroTheme.dimens.dimens30),
                    imageVector = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconEdit),
                    contentDescription = "Icon Edit"
                )
            }
        }
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPerson),
            title = "Nombre y apellidos",
            subTitle = "${user.name.first} ${user.name.last}"
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPersonEmail),
            title = "Email",
            subTitle = user.email
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPersonGender),
            title = "Género",
            subTitle = user.gender
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconDateRegister),
            title = "Fecha de registro",
            subTitle = user.registered.date.toFormattedDate()
        )
        InformationComponent(
            startIcon = painterResource(id = PTpmedieroTheme.icons.iconPhone),
            title = "Telefono",
            subTitle = user.phone
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
            modifier = Modifier.padding(
                horizontal = PTpmedieroTheme.dimens.dimens30,
                vertical = PTpmedieroTheme.dimens.dimens10
            )
        ) {
            CustomCircleImage(
                painter = startIcon,
                contentScale = ContentScale.Crop,
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
        DetailScreen(
            navController = rememberNavController(),
            email = ""
        )
    }
}