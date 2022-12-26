package com.volkankelleci.newsapp.repository

import androidx.lifecycle.LiveData
import com.volkankelleci.newsapp.model.Article
import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.retrofit.RetrofitAPI
import com.volkankelleci.newsapp.room.ArticleDAO
import com.volkankelleci.newsapp.util.Resource
import javax.inject.Inject

class NewsRespository@Inject constructor(
    val dao: ArticleDAO,
    val retrofitAPI: RetrofitAPI
):NewsRepositoryInterFace{
    override suspend fun insertNews(article: Article) {
        dao.insertArticles(article)
    }

    override suspend fun deleteAll(article: Article) {
       dao.deleteArticles(article)
    }

    override fun getNews(): LiveData<List<Article>> {
        return dao.getAllArticles()
    }

    override suspend fun newsSearch(searchQuery: String,pageNumber:Int)
    :Resource<NewsResponse> {
        return try {
            val response=retrofitAPI.searchForNews(searchQuery,pageNumber)
            if (response.isSuccessful){
            response.body()?.let {
            return@let Resource.success(it)
            }?:Resource.error("Error",null)
            }else{
                Resource.error("Error",null)
            }
        }catch (e:Exception){
            Resource.error("No Data",null)
        }

    }

}