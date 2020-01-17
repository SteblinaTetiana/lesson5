package com.example.steblinatetiana.lesson5.usergithubrepo

import android.annotation.SuppressLint
import android.app.Application
import com.example.steblinatetiana.lesson5.usergithubrepo.repository.myModule
import org.koin.core.context.startKoin

@SuppressLint("Registered")
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        //use koin and start it here
        startKoin {
            modules(myModule)
        }
    }
}