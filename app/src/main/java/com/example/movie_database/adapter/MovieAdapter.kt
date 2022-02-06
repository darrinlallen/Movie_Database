package com.example.movie_database.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_database.databinding.ItemMovieBinding
import com.example.movie_database.model.Search

class MovieAdapter (

    private val movies: List<Search>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindUrl(movies[position])

    }
    override fun getItemCount() = movies.size
    class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindUrl(movie: Search) {

            binding.tvMovie.text = movie.Title
        }


        companion object {
            fun newInstance(parent: ViewGroup) = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let { MovieViewHolder(it) }
//
        }
    }
}
