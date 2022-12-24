package com.volkankelleci.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.volkankelleci.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {
}