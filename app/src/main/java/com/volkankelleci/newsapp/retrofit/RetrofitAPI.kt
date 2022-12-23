package com.volkankelleci.newsapp.retrofit

import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.util.APIService.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {



    // = https://newsapi.org/v2/everything?q=apple&from=2022-12-22&to=2022-12-22&sortBy=popularity&apiKey=e6c42561bdc04456824b3bec6ac5bc99
    //GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String="tr",
        @Query("page")
        pageNumber:Int=1,
        @Query("API")
        apiKey:String=API_KEY

    ):Response<NewsResponse>
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber:Int=1,
        @Query("API")
        apiKey:String=API_KEY

    ):Response<NewsResponse>

}