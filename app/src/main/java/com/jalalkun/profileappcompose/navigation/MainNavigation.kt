package com.jalalkun.profileappcompose.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.jalalkun.profileappcompose.R
import com.jalalkun.profileappcompose.navigation.NavRoute.baseProfile

object NavRoute{
    const val baseProfile = "profile/"
}

sealed class MainNavigation(val route: String, @StringRes val name: Int, val icon: ImageVector) {
    object Home: MainNavigation("home_screen", R.string.home, Icons.Filled.Home)
    object Profile : MainNavigation("profile_screen", R.string.profile, Icons.Filled.Person)
    object FriendsList : MainNavigation("friendslist_screen", R.string.friends_list, Icons.Filled.List)
    object ProfileDetail : MainNavigation("$baseProfile{userId}", R.string.detail_profile, Icons.Filled.Person)
}

fun NavHostController.toDetailProfile(userId: String){
    navigate("%s%s".format(baseProfile, userId))
}