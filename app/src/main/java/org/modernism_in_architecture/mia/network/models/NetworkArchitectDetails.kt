package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.database.DatabaseArchitectDetails

data class NetworkArchitectDetails (
    @SerializedName("id") var id : Int,
    @SerializedName("lastName") var lastName : String? = null,
    @SerializedName("firstName" ) var firstName : String? = null,
    @SerializedName("birthDay") var birthDay : String? = null,
    @SerializedName("birthPlace") var birthPlace : String? = null,
    @SerializedName("birthCountry") var birthCountry : String? = null,
    @SerializedName("deathDay") var deathDay : String? = null,
    @SerializedName("deathPlace") var deathPlace : String? = null,
    @SerializedName("deathCountry") var deathCountry : String? = null,
    @SerializedName("description") var description : String? = null,
    @SerializedName("absoluteURL") var absoluteURL : String? = null,
    @SerializedName("relatedBuildings") var relatedBuildings : ArrayList<ArchitectBuilding> = arrayListOf(),
) {
    data class ArchitectBuilding(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("yearOfConstruction")
        var yearOfConstruction: String,
        @SerializedName("city")
        var city: String,
        @SerializedName("country")
        var country: String,
        @SerializedName("latitude")
        var latitude: Double,
        @SerializedName("longitude")
        var longitude: Double,
        @SerializedName("feedImage")
        var feedImage: String,
    )
}

fun NetworkArchitectDetails.asDatabaseModel(): DatabaseArchitectDetails {
    return DatabaseArchitectDetails(
        id = id,
        lastName = lastName ?: "",
        firstName = firstName ?: "",
        birthDay = birthDay ?: "",
        birthPlace = birthPlace ?: "",
        birthCountry = birthCountry ?: "",
        deathDay = deathDay ?: "",
        deathPlace = deathPlace ?: "",
        deathCountry = deathCountry ?: "",
        description = description ?: "",
        absoluteURL = absoluteURL ?: "",
        relatedBuildings = relatedBuildings,
    )
}
