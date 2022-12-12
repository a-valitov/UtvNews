package com.avalitov.utvnews.pages.stories.di

import com.avalitov.utvnews.pages.stories.StoriesVewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val storiesModule = module {
    viewModel {
        StoriesVewModel()
    }
}