package com.jalalkun.profileappcompose.ui.detail_profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.jalalkun.profileappcompose.R
import com.jalalkun.profileappcompose.data.model.DetailProfile
import com.jalalkun.profileappcompose.utils.NoImage

@Composable
fun DetailProfileScreen(detailProfile: DetailProfile) {
    Content(detailProfile = detailProfile)
}

@Composable
private fun Content(detailProfile: DetailProfile) {
    val menus = listOf(
        DetailPosition.Name,
        DetailPosition.Email,
        DetailPosition.Date,
        DetailPosition.Location,
        DetailPosition.Phone
    )

    var position by remember {
        mutableStateOf<DetailPosition>(DetailPosition.Name)
    }
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            val (photoProfile, content, listMenu) = createRefs()
            AsyncImage(
                model = detailProfile.picture,
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .clip(CircleShape)
                    .width(150.dp)
                    .height(150.dp)
                    .padding(16.dp)
                    .constrainAs(photoProfile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                placeholder = NoImage()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .constrainAs(content) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(photoProfile.bottom)
                        bottom.linkTo(listMenu.top)
                    }
            ) {
                Text(
                    text = "My ${position.name} is",
                    style = MaterialTheme.typography.titleSmall
                )
                when(position){
                    is DetailPosition.Name -> {
                        detailProfile.name
                    }
                    is DetailPosition.Email -> {
                        detailProfile.email
                    }
                    is DetailPosition.Date -> {
                        detailProfile.birthday
                    }
                    is DetailPosition.Location -> {
                        detailProfile.address
                    }
                    is DetailPosition.Phone -> {
                        detailProfile.phoneNumber
                    }
                }.let {
                    Text(
                        text = it,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(8.dp)
                    .constrainAs(listMenu) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(content.bottom)
                    }
            ) {
                menus.forEach { menu ->
                    NavigationBarItem(
                        selected = position.name == menu.name,
                        onClick = {
                                  position = menu
                        },
                        icon = {
                            Icon(imageVector = menu.iconActive, contentDescription = null)
                        }
                    )
                }
            }
        }
    }
}