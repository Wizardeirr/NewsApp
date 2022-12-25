package com.volkankelleci.newsapp.repository

import com.volkankelleci.newsapp.retrofit.RetrofitService
import com.volkankelleci.newsapp.room.ArticleDataBase

class NewsRepository(
    val db:ArticleDataBase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int)=
        RetrofitService.api.getBreakingNews(countryCode,pageNumber)


}