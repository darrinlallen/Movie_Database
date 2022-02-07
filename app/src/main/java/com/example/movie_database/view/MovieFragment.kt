package com.example.movie_database.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movie_database.adapter.MovieAdapter
import com.example.movie_database.databinding.MovieFragmentBinding
import com.example.movie_database.model.MovieDataClass
import com.example.movie_database.utils.ViewState
import com.example.movie_database.viewmodel.MovieViewModel

//Fragment with logic to print results to screen
class MovieFragment : Fragment() {
    private var _binding: MovieFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) = MovieFragmentBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() = with(viewModel) {
        viewState.observe(viewLifecycleOwner) { state ->
            if (state is ViewState.Success) handleSuccess(state.movies)
            if (state is ViewState.Error) handleError(state.exception)
        }

    }

    private fun handleSuccess(movies: MovieDataClass) {
        binding.rvMovies.adapter = MovieAdapter(movies.Search)
    }

    private fun handleError(exception: String) {
        Toast.makeText(context, exception, Toast.LENGTH_SHORT).show()
    }


}



