package com.project.cricbuzztask.ui.adapter.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.project.cricbuzztask.R
import com.project.cricbuzztask.listeners.onClick
import com.project.cricbuzztask.model.News
import com.squareup.picasso.Picasso

/**
 * Created by Sachin Verma on 2020-01-06.
 */

class NewsListViewHolder(itemView: View, private val listener: onClick) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var newImage: ImageView = itemView.findViewById(R.id.news_image)
    private var newsTitle: TextView = itemView.findViewById(R.id.news_title)
    private var newsDescription: TextView = itemView.findViewById(R.id.news_description)
    private var newsAuthor: TextView = itemView.findViewById(R.id.news_author)
    private var rowNews: ConstraintLayout = itemView.findViewById(R.id.cl_news_item_row)

    fun bind(news: News) {

        newsTitle.text = news.title
        newsDescription.text = news.description
        newsAuthor.text = news.author

        Picasso.get()
            .load(news.urlToImage)
            .placeholder(R.drawable.ic_poll_black_24dp)
            .error(R.drawable.ic_poll_black_24dp)
            .resize(250, 250)
            .centerCrop()
            .into(newImage)

        rowNews.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.cl_news_item_row -> listener.onItemClicked(adapterPosition)
        }
    }

}