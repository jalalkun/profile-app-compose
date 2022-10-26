package com.jalalkun.profileappcompose

import android.app.Application
import com.jalalkun.profileappcompose.data.module.apiModule
import com.jalalkun.profileappcompose.data.module.repositoryModule
import com.jalalkun.profileappcompose.data.module.viewModelModule
import com.jalalkun.profileappcompose.data.network.RetrofitModule.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApp)
            modules(listOf(
                //databaseModule,
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule
            ))
        }
    }
}