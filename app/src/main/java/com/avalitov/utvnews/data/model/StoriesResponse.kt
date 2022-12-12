package com.avalitov.utvnews.data.model

data class StoriesResponse (
    val status : String,
    val detail : Detail
)

data class Detail (
    val stories: List<Story>
)