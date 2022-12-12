package com.avalitov.utvnews

import android.app.Application
import android.content.Context
import com.avalitov.utvnews.main.di.MainDependencies.mainModule
import com.avalitov.utvnews.pages.stories.di.storiesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UtvApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Dependency injection starting point
        startKoin {
            modules(
                mainModule,
                storiesModule
            )
            androidContext(this@UtvApplication)
        }

        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}