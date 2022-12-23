package com.volkankelleci.newsapp.room

import androidx.room.TypeConverter

class RoomTypeConverter {
    @TypeConverter
    fun fromSource(source:com.volkankelleci.newsapp.model.Source):String{
        return source.name

    }
    @TypeConverter
    fun toSource(name:String): com.volkankelleci.newsapp.model.Source {
        return com.volkankelleci.newsapp.model.Source(name,name)
    }
}