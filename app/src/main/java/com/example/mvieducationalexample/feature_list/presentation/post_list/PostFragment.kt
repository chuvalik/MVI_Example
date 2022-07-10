package com.example.mvieducationalexample.feature_list.presentation.post_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.mvieducationalexample.databinding.FragmentPostBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<PostViewModel>()
    private var adapter: PostAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()

        observeState()
    }

    private fun setupAdapter() {
        adapter = PostAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { state ->
                processViewState(state)
            }
        }
    }

    private fun processViewState(state: PostState) {
        adapter?.submitList(state.data)

        binding.progressBar.isVisible = state.isLoading
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}