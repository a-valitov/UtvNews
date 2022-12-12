package com.avalitov.utvnews.pages.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avalitov.utvnews.databinding.FragmentStoriesBinding

class StoriesFragment : Fragment() {

    private lateinit var binding: FragmentStoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }
}