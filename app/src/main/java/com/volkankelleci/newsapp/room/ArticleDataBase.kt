package com.volkankelleci.newsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.volkankelleci.newsapp.model.Article
import retrofit2.Converter

@Database(entities = [Article::class], version = 1)
@TypeConverters(RoomTypeConverter::class)
abstract class ArticleDataBase:RoomDatabase() {
    abstract fun articleDao():ArticleDAO

    companion object{
        @Volatile
        private var instance:ArticleDataBase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: createDataBase(context).also {
                instance=it
            }

        }
        fun createDataBase(context: Context)= Room.databaseBuilder(context,ArticleDataBase::class.java,"save").build()
    }


}