package com.example.pruebatecnica.pablomediero.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pruebatecnica.pablomediero.core.composables.CustomCircleImage
import com.example.pruebatecnica.pablomediero.core.composables.CustomNavigationComponent
import com.example.pruebatecnica.pablomediero.core.ui.annotations.ThemePreviews
import com.example.pruebatecnica.pablomediero.core.ui.theme.PTpmedieroTheme
import com.example.pruebatecnica.pablomediero.core.ui.uistates.UIState
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.presentation.viewmodels.UserViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    userViewModel: UserViewModel = koinViewModel()
) {
    val usersData by userViewModel.usersFlow.collectAsState()
    val usersList = remember { mutableStateOf(emptyList<User>()) }
    val isLoading = remember { mutableStateOf(false) }
    when (val state = usersData) {
        UIState.Loading -> {
            isLoading.value = true
        }
        is UIState.Error -> {
            isLoading.value = false
        }
        is UIState.Success -> {
            usersList.value = state.data?.results!!
            isLoading.value = false
        }
    }
    LaunchedEffect(Unit){
        userViewModel.fetchRandomUsers()
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        HeaderHomeScreen(
            modifier = Modifier
                .padding(top = PTpmedieroTheme.dimens.dimens10)
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth(),
        )
        BodyHomeScreen(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(
                    top = PTpmedieroTheme.dimens.dimens10,
                    start = PTpmedieroTheme.dimens.dimens10
                )
                .fillMaxSize(),
            users = usersList.value,
            isLoading = isLoading.value

        )
    }

}

@Composable
fun HeaderHomeScreen(
    modifier: Modifier,
) {
    CustomNavigationComponent(
        modifier = modifier,
        startIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconArrowBack),
        text = stringResource(id = PTpmedieroTheme.strings.contacts),
        trailIcon = ImageVector.vectorResource(id = PTpmedieroTheme.icons.iconMoreActions),
        onStartIconClick = {},
        onTrailIconClick = {}
    )
}

@Composable
fun BodyHomeScreen(modifier: Modifier, users: List<User>, isLoading: Boolean) {
    Column(
        modifier = modifier
    ) {
        if(!isLoading){
            LazyColumn {
                items(users) { user ->
                    ItemUser(user)
                }
            }
        }else{
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

@Composable
private fun ItemUser(user: User) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = PTpmedieroTheme.dimens.dimens8)
            .clickable {
            }
    ) {
        Column(
            modifier = Modifier.padding(end = PTpmedieroTheme.dimens.dimens10)
        ) {
            CustomCircleImage(
                painter = rememberAsyncImagePainter(model = user.picture.thumbnail),
                contentScale = ContentScale.FillBounds,
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
                        text = "${user.name.first} ${user.name.last}",
                        style = PTpmedieroTheme.types.typography.titleSmall,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(PTpmedieroTheme.dimens.dimens4))
                    Text(
                        text = user.email,
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