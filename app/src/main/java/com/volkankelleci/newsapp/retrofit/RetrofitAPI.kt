package com.volkankelleci.newsapp.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {



    // = https://newsapi.org/v2/everything?q=apple&from=2022-12-22&to=2022-12-22&sortBy=popularity&apiKey=e6c42561bdc04456824b3bec6ac5bc99
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String="tr",
        @Query("page")
        pageNumber:Int=1,

    )
    //GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
}