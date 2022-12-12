package com.avalitov.utvnews.pages.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.avalitov.utvnews.databinding.FragmentStoriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoriesFragment : Fragment() {

    private lateinit var binding: FragmentStoriesBinding
    private val viewModel by viewModel<StoriesViewModel>()

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
        viewModel.stories.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty().not()) {
                binding.textHello.text = it.toString()
            } else {
                Toast.makeText(
                    activity,
                    "No response has come from server.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}