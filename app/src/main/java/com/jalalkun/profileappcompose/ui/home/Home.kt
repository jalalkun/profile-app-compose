package com.jalalkun.profileappcompose.ui.home

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.navigation.NavHostController
import com.jalalkun.profileappcompose.data.model.DataProfile
import com.jalalkun.profileappcompose.data.model.DetailProfile
import com.jalalkun.profileappcompose.data.utils.Resource
import com.jalalkun.profileappcompose.data.viewModel.ProfileViewModel
import com.jalalkun.profileappcompose.ui.navigation.toDetailProfile
import com.jalalkun.profileappcompose.utils.isScrolledToTheEnd
import com.jalalkun.profileappcompose.widget.DataNotFound
import com.jalalkun.profileappcompose.widget.ErrorAlert
import com.jalalkun.profileappcompose.widget.Loading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomeScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = koinViewModel()
) {
    val listProfile = profileViewModel.profilesFlow.collectAsState().value
    LaunchedEffect(key1 = Unit, block = {
        if (profileViewModel.dataProfiles.isEmpty()) profileViewModel.getProfiles()
    })

    when (listProfile) {
        is Resource.Error -> {
            ErrorAlert(message = listProfile.message) {
                profileViewModel.dismissError()
            }
        }

        is Resource.Success<*> -> {
            profileViewModel.success()
            val result = listProfile.data as List<*>
            result.forEach {
                if (it is DataProfile &&  !profileViewModel.dataProfiles.contains(it) && it.id?.value != null) {
                    profileViewModel.dataProfiles.add(it)
                }
            }
        }

        is Resource.Loading -> {
            Loading()
        }

        else -> {
            DataNotFound()
        }
    }
    HomeContent(
        profileViewModel = profileViewModel,
        navController = navController
    )
}

@Composable
private fun HomeContent(
    profileViewModel: ProfileViewModel,
    navController: NavHostController
) {
    val list = remember {
        profileViewModel.dataProfiles
    }
    val coroutine = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    if (list.isEmpty()) DataNotFound()
    else {
        LazyColumn(
            content = {
                items(
                    count = list.size,
                    key = {
                        list[it].id?.name + list[it].id?.value
                    }
                ) {
                    val profile = list[it]
                    CardProfile(dataProfile = profile) {
                        Log.e("MainNavigation", "toDetailProfile: ")
                        coroutine.launch(Dispatchers.IO) {
                            val detailProfile =
                                DetailProfile(
                                    name = "%s, %s %s".format(
                                        profile.name?.title,
                                        profile.name?.first,
                                        profile.name?.last
                                    ),
                                    phoneNumber = profile.phone.toString(),
                                    email = profile.email.toString(),
                                    address = "%s %s %s".format(
                                        profile.location?.street,
                                        profile.location?.city,
                                        profile.location?.state
                                    ),
                                    birthday = profile.dob?.date.toString(),
                                    picture = URLEncoder.encode(
                                        profile.picture?.large.toString(),
                                        StandardCharsets.UTF_8.toString()
                                    )
                                )
                            navController.toDetailProfile(detailProfile)
                        }
                    }
                }
            },
            state = lazyListState,
        )
    }
    LaunchedEffect(Unit) {
        snapshotFlow { lazyListState.isScrolledToTheEnd() }
            .collect {
                if (it && list.isNotEmpty()) profileViewModel.getProfiles()
            }
    }
}