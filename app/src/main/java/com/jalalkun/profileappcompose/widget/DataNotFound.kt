package com.jalalkun.profileappcompose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jalalkun.profileappcompose.R

@Preview
@Composable
fun DataNotFound() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Outlined.Info,
            contentDescription = stringResource(id = R.string.data_not_found),
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )
        Text(
            text = stringResource(id = R.string.data_not_found),
            modifier = Modifier.padding(6.dp),
            fontSize = 22.sp
        )
    }
}