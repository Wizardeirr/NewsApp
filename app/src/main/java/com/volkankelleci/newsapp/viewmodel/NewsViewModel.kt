package com.volkankelleci.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(
    val newsRepository: NewsRepository,
):ViewModel() {
    val breakingNews:MutableLiveData<Resource<NewsResponse>> =MutableLiveData()
    var breakingPages=1

    init {
        getBreakingNews("tr")
    }

    fun getBreakingNews(countryCode:String){
        viewModelScope.launch {
            newsRepository.getBreakingNews(countryCode,breakingPages)
        }
    }





}