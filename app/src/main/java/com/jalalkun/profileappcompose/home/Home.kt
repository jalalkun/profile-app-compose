package com.jalalkun.profileappcompose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jalalkun.profileappcompose.navigation.toDetailProfile

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        Text(text = navController.currentDestination?.route ?: "")
        Button(onClick = { navController.toDetailProfile("15")}) {
            Text(text = "to Detail")
        }
    }

}