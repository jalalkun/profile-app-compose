package com.jalalkun.profileappcompose.friends_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun FriendsListScreen(navController: NavController){
    Text(text = navController.currentDestination?.route ?: "")
}