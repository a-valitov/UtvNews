package com.avalitov.utvnews.pages.stories

import androidx.lifecycle.MutableLiveData
import com.avalitov.utvnews.common.BaseViewModel
import java.util.*

class StoriesVewModel : BaseViewModel() {

    // Test
    var timeState : MutableLiveData<Date> = MutableLiveData()

    init {
        timeState.value = Date()
    }
}