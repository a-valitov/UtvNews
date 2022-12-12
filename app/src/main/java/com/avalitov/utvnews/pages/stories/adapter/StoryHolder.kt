package com.avalitov.utvnews.pages.stories.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avalitov.utvnews.R
import com.avalitov.utvnews.common.extensions.asString
import com.avalitov.utvnews.data.model.Story
import com.bumptech.glide.Glide
import java.util.*

class StoryHolder(
    itemView: View,
    //listener: StoriesAdapter.OnStoryClickListener?
    ) : RecyclerView.ViewHolder(itemView) {

    private val headerView: TextView = itemView.findViewById(R.id.rv_item_header)
    private val dateView: TextView = itemView.findViewById(R.id.rv_item_date)
    private val previewView: ImageView = itemView.findViewById(R.id.rv_item_preview)

    fun bind(story: Story) {
        headerView.text = story.news_name
        dateView.text = Date(story.date * 1000).asString()  // conversion from unix time

        Glide.with(previewView)
            .load(story.image_logo)
            .placeholder(R.drawable.logo_utv)
            .error(R.drawable.ic_launcher_background)   // TODO: Replace
            .fitCenter()
            .into(previewView)

//        itemView.setOnClickListener {
//            listener?.onClick(story)
//        }
    }
}