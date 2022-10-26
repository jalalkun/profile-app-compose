package com.jalalkun.profileappcompose.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController){
    Text(text = navController.currentDestination?.route ?: "")
}