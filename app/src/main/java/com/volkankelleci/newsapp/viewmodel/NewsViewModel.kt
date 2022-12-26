package com.volkankelleci.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.room.ArticleDAO
import kotlinx.coroutines.launch

class NewsViewModel(
    val newsRepository: NewsRepository,
    val  dao:ArticleDAO
):ViewModel() {
    val news= MutableLiveData<List<NewsResponse>>()
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