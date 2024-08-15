package com.example.compose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.compose.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun  sourceToString(source: Source): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(value: String): Source{
        val (id, name) = value.split(",")
        return Source(id, name)
    }
}