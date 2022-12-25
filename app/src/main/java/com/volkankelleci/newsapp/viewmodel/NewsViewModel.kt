package com.volkankelleci.newsapp.viewmodel

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.repository.NewsRepository
import com.volkankelleci.newsapp.util.Resource.Companion.loading
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository,
):ViewModel() {
    val breakingNews:MutableLiveData<Resource<NewsResponse>> =MutableLiveData()
    var breakingPages=1


    fun getBreakingNews(countryCode:String){
        viewModelScope.launch {
            newsRepository.getBreakingNews(countryCode,breakingPages)
        }
    }
   




}