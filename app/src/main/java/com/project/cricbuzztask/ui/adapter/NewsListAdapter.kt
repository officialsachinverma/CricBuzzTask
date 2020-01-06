package com.project.cricbuzztask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.project.cricbuzztask.listeners.onClick
import com.project.cricbuzztask.model.News
import com.project.cricbuzztask.ui.adapter.viewholder.NewsListViewHolder

/**
 * Created by Sachin Verma on 2020-01-06.
 */

class NewsListAdapter(private val view: Int, private val listener: onClick) : ListAdapter<News, NewsListViewHolder>(NewsDiffUtil())  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = NewsListViewHolder(LayoutInflater.from(parent.context).inflate(view, parent, false), listener)

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewsDiffUtil: DiffUtil.ItemCallback<News>() {

        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }

    }
}