package com.volkankelleci.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.volkankelleci.newsapp.MainActivity
import com.volkankelleci.newsapp.R
import com.volkankelleci.newsapp.adapter.ArticleAdapter
import com.volkankelleci.newsapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment(R.layout.fragment_news) {
    lateinit var viewModel:NewsViewModel
    lateinit var articleAdapter:ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as MainActivity).viewModel
    }

    private fun setupRecyclerView(){
        articleAdapter=ArticleAdapter()
        breakingNewsRecycler.apply {
            adapter=articleAdapter
            layoutManager=LinearLayoutManager(activity)
        }
    }
}