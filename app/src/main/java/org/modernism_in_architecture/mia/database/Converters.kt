package org.modernism_in_architecture.mia.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.modernism_in_architecture.mia.network.models.NetworkArchitectDetails.ArchitectBuilding
import org.modernism_in_architecture.mia.network.models.NetworkBuildingDetails.Architect

class ArchitectConverter {

    @TypeConverter
    fun toArchitectsList(value: String): ArrayList<Architect> {
        if (value == "") {
            return arrayListOf()
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Architect>>() {}.type
        return gson.fromJson(value, type)
    }
    @TypeConverter
    fun fromArchitectsList(value: ArrayList<Architect>): String {
        if(value == null) {
            return ""
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Architect>>() {}.type
        return gson.toJson(value, type)
    }
}

class RelatedBuildingConverter {

    @TypeConverter
    fun toRelatedBuildingList(value: String): ArrayList<ArchitectBuilding> {
        if (value == "") {
            return arrayListOf()
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<ArchitectBuilding>>() {}.type
        return gson.fromJson(value, type)
    }
    @TypeConverter
    fun fromRelatedBuildingList(value: ArrayList<ArchitectBuilding>): String {
        if(value == null) {
            return ""
        }
        val gson = Gson()
        val type = object : TypeToken<ArrayList<ArchitectBuilding>>() {}.type
        return gson.toJson(value, type)
    }
}


class StringListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}