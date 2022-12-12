package com.avalitov.utvnews.pages.stories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.avalitov.utvnews.common.BaseViewModel
import com.avalitov.utvnews.data.model.Story
import com.avalitov.utvnews.network.WebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoriesViewModel(private val webRepo: WebRepository) : BaseViewModel() {

    var stories : MutableLiveData<List<Story>> = MutableLiveData()

    // To show progress bar while loading and hide afterwards
    val progressState: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getStories()
    }

    private fun getStories() {
        progressState.value = true

        viewModelScope.launch(Dispatchers.IO) {
            val response = webRepo.loadStories()
            withContext(Dispatchers.Main) {
                stories.value = response.detail.stories
                progressState.value = false
            }
        }
    }

    companion object {
        private const val TAG = "STORIES_VM"
    }
}