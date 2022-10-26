package com.jalalkun.profileappcompose.data.module

import com.jalalkun.profileappcompose.data.viewModel.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ProfileViewModel(get()) }
}