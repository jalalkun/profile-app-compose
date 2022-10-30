package com.jalalkun.profileappcompose.ui.detail_profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DetailPosition(val name: String, val iconActive: ImageVector, iconNonActive: ImageVector){
    object Name: DetailPosition("Name", Icons.Filled.Person, Icons.Default.Person)
    object Email: DetailPosition("Email", Icons.Filled.Email, Icons.Default.Email)
    object Date: DetailPosition("Birthday", Icons.Filled.DateRange, Icons.Default.DateRange)
    object Location: DetailPosition("Address", Icons.Filled.LocationOn, Icons.Default.LocationOn)
    object Phone: DetailPosition("Phone", Icons.Filled.Phone, Icons.Default.Phone)
}

