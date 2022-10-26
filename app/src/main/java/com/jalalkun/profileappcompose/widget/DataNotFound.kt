package com.jalalkun.profileappcompose.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jalalkun.profileappcompose.R

@Composable
fun DataNotFound() {
    Box(
        modifier = Modifier.size(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                imageVector = Icons.Filled.Info,
                contentDescription = stringResource(id = R.string.data_not_found)
            )
        }
        Text(
            text = stringResource(id = R.string.data_not_found),
            modifier = Modifier.padding(6.dp)
        )
    }
}