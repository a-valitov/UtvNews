package com.avalitov.utvnews.pages.stories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.avalitov.utvnews.common.BaseViewModel
import com.avalitov.utvnews.data.model.Story
import com.avalitov.utvnews.network.ConnectionHelper
import com.avalitov.utvnews.network.WebRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoriesViewModel(
    private val webRepo: WebRepository,
    private val connectionHelper: ConnectionHelper
        ) : BaseViewModel() {

    var stories : MutableLiveData<List<Story>> = MutableLiveData()

    // To show progress bar while loading and hide afterwards
    val progressState: MutableLiveData<Boolean> = MutableLiveData(false)

    // To avoid sending requests to server if not connected
    val networkState: MutableLiveData<Boolean> = MutableLiveData()

    init {
        networkState.value = connectionHelper.isOnline()
        if (networkState.value == true) {
            getStories()
        }
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