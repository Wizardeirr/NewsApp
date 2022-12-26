package com.volkankelleci.newsapp.repository

import androidx.lifecycle.LiveData
import com.volkankelleci.newsapp.model.Article
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.util.Resource

interface NewsRepositoryInterFace {
    suspend fun insertNews(article: Article)
    suspend fun deleteAll(article: Article)
    fun getNews(): LiveData<List<Article>>
    suspend fun newsSearch(searchQuery:String,pageNumber:Int): Resource<NewsResponse>
}