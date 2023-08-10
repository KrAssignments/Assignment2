package com.krupal.assignment1.ui

import androidx.recyclerview.widget.RecyclerView
import com.krupal.assignment1.R
import com.krupal.assignment1.common.loadImage
import com.krupal.assignment1.databinding.LayoutMovieItemBinding

class MoviesViewHolder(private val binding: LayoutMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.text.isSelected = true
    }

    fun bind(state: MoviesItemUIState) {
        with(binding) {
            text.text = state.getName()
            image.loadImage(
                when (state.getImageUrl()) {
                    "poster1.jpg" -> R.drawable.poster1
                    "poster2.jpg" -> R.drawable.poster2
                    "poster3.jpg" -> R.drawable.poster3
                    "poster4.jpg" -> R.drawable.poster4
                    "poster5.jpg" -> R.drawable.poster5
                    "poster6.jpg" -> R.drawable.poster6
                    "poster7.jpg" -> R.drawable.poster7
                    "poster8.jpg" -> R.drawable.poster8
                    "poster9.jpg" -> R.drawable.poster9
                    else -> R.drawable.placeholder_for_missing_posters
                }
            )
        }
    }
}