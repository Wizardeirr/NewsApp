package com.volkankelleci.newsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.volkankelleci.newsapp.model.Article

@Database(entities = [Article::class], version = 1)
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