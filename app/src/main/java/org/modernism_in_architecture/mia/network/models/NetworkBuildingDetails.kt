package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.database.DatabaseBuildingDetails


data class NetworkBuildingDetails (
    @SerializedName("id"                 ) var id                 : Int,
    @SerializedName("name"               ) var name               : String?               = null,
    @SerializedName("yearOfConstruction" ) var yearOfConstruction : String?               = null,
    @SerializedName("isProtected"        ) var isProtected        : Boolean?              = null,
    @SerializedName("address"            ) var address            : String?               = null,
    @SerializedName("zipCode"            ) var zipCode            : String?               = null,
    @SerializedName("city"               ) var city               : String?               = null,
    @SerializedName("country"            ) var country            : String?               = null,
    @SerializedName("latitude"           ) var latitude           : Double?               = null,
    @SerializedName("longitude"          ) var longitude          : Double?               = null,
    @SerializedName("galleryImages"      ) var galleryImages      : List<String>     = arrayListOf(),
    @SerializedName("subtitle"           ) var subtitle           : String?               = null,
    @SerializedName("todaysUse"          ) var todaysUse          : String?               = null,
    @SerializedName("buildingType"       ) var buildingType       : String?               = null,
    @SerializedName("history"            ) var history            : String?               = null,
    @SerializedName("description"        ) var description        : String?               = null,
    @SerializedName("architects"         ) var architects         : ArrayList<Architect> = arrayListOf(),
    @SerializedName("absoluteURL"        ) var absoluteURL        : String?               = null

) {
    data class Architect(
        @SerializedName("id")
        var id: Int,
        @SerializedName("lastName")
        var lastName: String,
        @SerializedName("firstName")
        var firstName: String,
    )
}

fun NetworkBuildingDetails.asDatabaseModel(): DatabaseBuildingDetails {
    return DatabaseBuildingDetails(
        id = id,
        name = name ?: "",
        feedImage = galleryImages[0],
        todaysUse = todaysUse ?: "",
        buildingType = buildingType ?: "",
        address = address ?: "",
        zipCode = zipCode ?: "",
        city = city ?: "",
        country = country ?: "",
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        history = history ?: "",
        description = description ?: "",
        yearOfConstruction = yearOfConstruction ?: "",
        absoluteURL = absoluteURL ?: "",
        galleryImages = galleryImages,
        architects = architects,
    )
}
