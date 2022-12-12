package com.avalitov.utvnews.main.di

import com.avalitov.utvnews.network.ConnectionHelper
import com.avalitov.utvnews.network.WebRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object MainDependencies {
    val mainModule = module {
        single {
            WebRepository()
        }
        single {
            ConnectionHelper(androidApplication().applicationContext)
        }
    }
}