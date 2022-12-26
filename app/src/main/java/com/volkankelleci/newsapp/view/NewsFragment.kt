package com.volkankelleci.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
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
    private lateinit var viewModel:NewsViewModel
    private lateinit var articleAdapter:ArticleAdapter
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
        val viewModel=ViewModelProvider(requireActivity()).get(NewsViewModel::class.java)



    }



}