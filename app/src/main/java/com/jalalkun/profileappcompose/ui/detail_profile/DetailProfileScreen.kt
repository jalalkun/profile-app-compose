package com.jalalkun.profileappcompose.ui.detail_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jalalkun.profileappcompose.data.model.DataProfile

@Composable
fun DetailProfileScreen(navController: NavController, dataProfile: DataProfile){
    Column {
        Text(text = navController.currentDestination?.route ?: "")
    }
}