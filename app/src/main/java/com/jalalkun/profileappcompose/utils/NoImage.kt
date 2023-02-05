package com.jalalkun.profileappcompose.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.jalalkun.profileappcompose.R

@Composable
fun NoImage(): Painter{
    return painterResource(id = R.drawable.no_image)
}