package com.project.cricbuzztask.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.project.cricbuzztask.R
import com.project.cricbuzztask.listeners.onClick
import com.project.cricbuzztask.model.News
import com.project.cricbuzztask.ui.adapter.NewsListAdapter
import com.project.cricbuzztask.ui.viewmodel.NewsListViewModel


class NewsListActivity : AppCompatActivity(), onClick {

    @BindView(R.id.rv_news)
    lateinit var rvVideoList: RecyclerView

    @BindView(R.id.empty_msg)
    lateinit var tvEmptyList: TextView

    @BindView(R.id.pg_waiting_sign)
    lateinit var waitingSign: ProgressBar

    private lateinit var adapter: NewsListAdapter
    private var newsList = listOf<News>()
    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        init()
    }

    private fun init() {
        newsListViewModel = NewsListViewModel(this)

        initAdapter()

        observeForObservable()

        setDataToAdapter(newsListViewModel.newsList.value!!)
    }

    private fun observeForObservable() {
        newsListViewModel.newsList.observe(this, Observer {
            hideWaitingSign()
            if (it.isNotEmpty()) {
                newsList = it
                showList()
                setDataToAdapter(it)
            } else {
                showEmptyMsg()
                hideList()
            }
        })
    }

    private fun setDataToAdapter(list: List<News>) {
        adapter.submitList(list)
    }

    private fun initAdapter() {
        adapter = NewsListAdapter(R.layout.row_news_item, this)
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        rvVideoList.layoutManager = linearLayout
        rvVideoList.adapter = adapter
    }

    override fun onItemClicked(position: Int) {
        NewsDetails.start(this, newsList[position].url, newsList[position].urlToImage)
    }

    fun showWaitingSign() {
        waitingSign.visibility = View.VISIBLE
    }

    fun hideWaitingSign() {
        waitingSign.visibility = View.GONE
    }

    fun showEmptyMsg() {
        tvEmptyList.visibility = View.VISIBLE
    }

    fun hideEmptyMsg() {
        tvEmptyList.visibility = View.GONE
    }

    fun showList() {
        rvVideoList.visibility = View.VISIBLE
    }

    fun hideList() {
        rvVideoList.visibility = View.GONE
    }
}