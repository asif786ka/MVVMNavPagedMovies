package com.kotproj.mvvmnavigationpagedmovies.moviedetails.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotproj.mvvmnavigationpagedmovies.databinding.ViewHolderMovieBinding
import com.kotproj.mvvmnavigationpagedmovies.moviedetails.data.Movie

class MoviePagingAdapter : PagingDataAdapter<Movie, MoviePagingAdapter.MyViewHolder>(DIFF_UTIL) {


    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }


    inner class MyViewHolder(val viewDataBinding: ViewHolderMovieBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.setVariable(com.kotproj.mvvmnavigationpagedmovies.BR.movie, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

}