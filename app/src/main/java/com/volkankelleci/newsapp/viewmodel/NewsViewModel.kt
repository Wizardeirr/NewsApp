package com.volkankelleci.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {
    val breakingNews=MutableLiveData<Resource<NewsResponse>>()
    var breakingPages=1
}