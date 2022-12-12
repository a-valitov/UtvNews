package com.avalitov.utvnews.pages.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.avalitov.utvnews.databinding.FragmentStoriesBinding
import com.avalitov.utvnews.pages.stories.adapter.StoriesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoriesFragment : Fragment() {

    private lateinit var binding: FragmentStoriesBinding
    private val viewModel by viewModel<StoriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        setUpSubscriptions()
    }

    private fun setUpUI() {
        binding.recycler.apply {
            layoutManager = StaggeredGridLayoutManager(
                GRID_SPAN_COUNT,
                RecyclerView.VERTICAL
            )

            if (adapter !is StoriesAdapter) {
                adapter = StoriesAdapter().apply {
                    //onTrackClickListener = this@TracksFragment
                }
            }
        }
    }

    private fun setUpSubscriptions() {
        viewModel.stories.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty().not()) {
                (binding.recycler.adapter as? StoriesAdapter)?.setItems(it)
            } else {
                Toast.makeText(
                    activity,
                    "No response has come from server.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        private const val GRID_SPAN_COUNT = 3
    }
}