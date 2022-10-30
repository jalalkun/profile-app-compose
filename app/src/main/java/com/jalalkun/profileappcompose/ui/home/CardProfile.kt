package com.jalalkun.profileappcompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.jalalkun.profileappcompose.R
import com.jalalkun.profileappcompose.data.model.DataProfile

@Composable
fun CardProfile(dataProfile: DataProfile, myClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .padding(5.dp)
            .clickable {
                myClick()
            }
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (photo, name, location, imageLocation) = createRefs()
            AsyncImage(
                model = dataProfile.picture?.medium,
                contentDescription = stringResource(id = R.string.thumbnail_home_profile_image),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .constrainAs(photo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Text(
                text = "%s. %s %s".format(dataProfile.name?.title, dataProfile.name?.first, dataProfile.name?.last),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .constrainAs(name) {
                        start.linkTo(photo.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(imageLocation.top)
                    }
            )

            Image(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = stringResource(id = R.string.location_icon),
                modifier = Modifier
                    .widthIn(min = 10.dp, max = 25.dp)
                    .heightIn(min = 10.dp, max = 10.dp)
                    .padding(start = 6.dp)
                    .constrainAs(imageLocation) {
                        start.linkTo(photo.end)
                        top.linkTo(name.bottom)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Text(
                text = "%s, %s, %s".format(dataProfile.location?.city, dataProfile.location?.state, dataProfile.location?.country),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .constrainAs(location) {
                        start.linkTo(imageLocation.end)
                        top.linkTo(name.bottom)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}