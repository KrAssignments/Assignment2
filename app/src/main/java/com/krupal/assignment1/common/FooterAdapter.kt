package com.krupal.assignment1.common

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.krupal.assignment1.R
import com.krupal.assignment1.databinding.LayoutPagingFooterBinding

class FooterAdapter constructor(
    private val context: Context,
    private val retry: () -> Unit
) : LoadStateAdapter<FooterViewHolder>() {
    override fun onBindViewHolder(holder: FooterViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): FooterViewHolder {
        val binding = DataBindingUtil.inflate<LayoutPagingFooterBinding>(
            LayoutInflater.from(context),
            R.layout.layout_paging_footer,
            parent,
            false
        )
        return FooterViewHolder(binding, retry)
    }
}