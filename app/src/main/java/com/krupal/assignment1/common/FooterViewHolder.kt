package com.krupal.assignment1.common

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.krupal.assignment1.databinding.LayoutPagingFooterBinding
import com.krupal.assignment1.util.executeWithAction

class FooterViewHolder constructor(
    private val binding: LayoutPagingFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        binding.executeWithAction {
            footerUIState = FooterUIState(loadState)
        }
    }
}