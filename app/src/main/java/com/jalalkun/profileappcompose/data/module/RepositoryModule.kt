package com.jalalkun.profileappcompose.data.module

import com.jalalkun.profileappcompose.data.repository.ProfileRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProfileRepository(get()) }
}