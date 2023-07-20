package com.krupal.assignment1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krupal.assignment1.R
import com.krupal.assignment1.databinding.LayoutListadapterItemBinding

class MoviesListAdapter(private val context: Context) :
    RecyclerView.Adapter<MoviesListAdapter.InnerViewHolder>() {
    private val list: List<Unit> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InnerViewHolder {
        val view = LayoutListadapterItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return InnerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20
//        return list.size
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        holder.bind(Unit)
    }

    fun reset() {
        notifyDataSetChanged()
    }

    fun search(it: String) {

    }

    open inner class InnerViewHolder(private val view: LayoutListadapterItemBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(item: Unit) {
            view.image.setImageResource(R.drawable.poster1)
        }
    }
}