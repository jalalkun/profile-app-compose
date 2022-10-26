package com.jalalkun.profileappcompose.detail_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailProfileScreen(navController: NavController, userId: String){
    Column {
        Text(text = navController.currentDestination?.route ?: "")
        Text(text = "id $userId")
    }
}