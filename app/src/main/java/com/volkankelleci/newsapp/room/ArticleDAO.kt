package com.volkankelleci.newsapp.room

import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.volkankelleci.newsapp.model.Article
import com.volkankelleci.newsapp.retrofit.RetrofitAPI

@Database(entities = [RetrofitAPI::class], version = 1)
interface ArticleDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(article: Article):Long

    @Delete
    suspend fun deleteArticles(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<Article>>
}