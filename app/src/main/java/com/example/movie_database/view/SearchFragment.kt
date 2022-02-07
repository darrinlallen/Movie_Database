package com.example.movie_database.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.movie_database.R
import com.example.movie_database.databinding.SearchFragmentBinding
import com.example.movie_database.viewmodel.MovieViewModel
// logic to interact with search screen

class SearchFragment : Fragment()  {
    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MovieViewModel>()
    public  var passInput = " "

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) = SearchFragmentBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListners()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




    private fun initListners() = with(binding) {

        button.setOnClickListener {
            val input = (tvMovie.text.toString())
            val action = SearchFragmentDirections.actionSearchFragmentToMovieFragment(input)
            findNavController().navigate(action)
        }
    }

}