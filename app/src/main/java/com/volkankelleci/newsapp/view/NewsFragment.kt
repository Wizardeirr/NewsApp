package com.volkankelleci.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.volkankelleci.newsapp.MainActivity
import com.volkankelleci.newsapp.R
import com.volkankelleci.newsapp.adapter.ArticleAdapter
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.util.Resource
import com.volkankelleci.newsapp.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import okhttp3.Response


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
        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {response->
            response?.let {
                if (it!=null){
                    Resource.success(Resource)
                it.get()?.let {newsResponse ->
                    articleAdapter.arts=newsResponse.articles
                }
                }

                progressBar.visibility=View.GONE
            }

        })

    }

    private fun setupRecyclerView(){
        articleAdapter=ArticleAdapter()
        breakingNewsRecycler.apply {
            adapter=articleAdapter
            layoutManager=LinearLayoutManager(activity)
        }
    }
}