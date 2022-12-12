package com.avalitov.utvnews.pages.stories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avalitov.utvnews.R
import com.avalitov.utvnews.data.model.Story

class StoriesAdapter: RecyclerView.Adapter<StoryHolder>() {

    private var stories = listOf<Story>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_card, parent, false)
        return StoryHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoryHolder, position: Int) =
        holder.bind(stories[position])

    override fun getItemCount(): Int {
        return stories.size
    }

    fun setItems(list: List<Story>) {
        stories = list
        notifyDataSetChanged()
    }
}