package com.jalalkun.profileappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jalalkun.profileappcompose.detail_profile.DetailProfileScreen
import com.jalalkun.profileappcompose.friends_list.FriendsListScreen
import com.jalalkun.profileappcompose.home.HomeScreen
import com.jalalkun.profileappcompose.navigation.MainNavigation
import com.jalalkun.profileappcompose.profile.ProfileScreen
import com.jalalkun.profileappcompose.ui.theme.ProfileAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppComposeTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InitNavigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InitNavigation() {
    val navController = rememberNavController()
    val items = listOf(
        MainNavigation.Home,
        MainNavigation.FriendsList,
        MainNavigation.Profile,
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.name)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                if (screen.route == MainNavigation.Home.route)popUpTo(MainNavigation.ProfileDetail.route)
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainNavigation.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MainNavigation.Home.route) { HomeScreen(navController = navController) }
            composable(MainNavigation.FriendsList.route) { FriendsListScreen(navController) }
            composable(MainNavigation.Profile.route) { ProfileScreen(navController) }
            composable(MainNavigation.ProfileDetail.route) {
                it.arguments?.getString("userId")?.let { it1 ->
                    DetailProfileScreen(
                        navController = navController,
                        userId = it1
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProfileAppComposeTheme {
        InitNavigation()
    }
}