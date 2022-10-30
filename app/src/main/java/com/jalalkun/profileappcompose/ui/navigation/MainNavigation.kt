package com.jalalkun.profileappcompose.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.jalalkun.profileappcompose.R
import com.jalalkun.profileappcompose.data.model.DetailProfile
import com.jalalkun.profileappcompose.ui.navigation.NavRoute.baseProfile
import com.jalalkun.profileappcompose.ui.navigation.NavRoute.profileUserId

object NavRoute{
    const val profileUserId = "{userId}"
    const val baseProfile = "profile/"
}

sealed class MainNavigation(val route: String, @StringRes val name: Int, val icon: ImageVector) {
    object Home: MainNavigation("home_screen", R.string.home, Icons.Filled.Home)
    object Profile : MainNavigation("profile_screen", R.string.profile, Icons.Filled.Person)
    object FriendsList : MainNavigation("friendslist_screen", R.string.friends_list, Icons.Filled.List)
    object ProfileDetail : MainNavigation("$baseProfile$profileUserId", R.string.detail_profile, Icons.Filled.Person)
}

fun NavHostController.toDetailProfile(detailProfile: DetailProfile){
    navigate("$baseProfile${Gson().toJson(detailProfile)}")
}