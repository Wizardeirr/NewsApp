package com.volkankelleci.newsapp.retrofit

import com.volkankelleci.newsapp.model.NewsResponse
import com.volkankelleci.newsapp.util.APIService.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private val api=Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)
    fun getData():Single<List<NewsResponse>>{
        return api.getBreakingNews()
    }
 }