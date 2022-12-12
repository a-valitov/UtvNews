package com.avalitov.utvnews.main.di

import com.avalitov.utvnews.network.WebRepository
import org.koin.dsl.module

object MainDependencies {
    val mainModule = module {
        single {
            WebRepository()
        }
    }
}