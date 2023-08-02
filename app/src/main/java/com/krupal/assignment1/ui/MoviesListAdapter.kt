package com.krupal.assignment1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.krupal.assignment1.databinding.LayoutMovieItemBinding
import javax.inject.Inject

class MoviesListAdapter @Inject constructor(private val context: Context) :
    PagingDataAdapter<MoviesItemUIState, MoviesViewHolder>(diffCallback = Comparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        val view = LayoutMovieItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        getItem(position)?.let { moviesItemUIState -> holder.bind(moviesItemUIState) }
    }

    fun reset() {
        refresh()
    }

    fun search(it: String) {

    }

    object Comparator : DiffUtil.ItemCallback<MoviesItemUIState>() {
        override fun areItemsTheSame(
            oldItem: MoviesItemUIState,
            newItem: MoviesItemUIState
        ): Boolean {
            return oldItem.getName() == newItem.getName()
        }

        override fun areContentsTheSame(
            oldItem: MoviesItemUIState,
            newItem: MoviesItemUIState
        ): Boolean {
            return oldItem == newItem
        }
    }
}