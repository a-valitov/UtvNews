package com.avalitov.utvnews.pages.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avalitov.utvnews.common.extensions.asString
import com.avalitov.utvnews.databinding.FragmentStoriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoriesFragment : Fragment() {

    private lateinit var binding: FragmentStoriesBinding
    private val viewModel by viewModel<StoriesVewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        setUpSubscriptions()
    }

    private fun setUpUI() {
        // TODO: Implement setUpUI()
    }

    private fun setUpSubscriptions() {
        viewModel.timeState.observe(viewLifecycleOwner) {
            binding.textHello.text = it.asString()
        }
    }
}