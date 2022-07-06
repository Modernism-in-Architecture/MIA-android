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
    @SerializedName("galleryImages"      ) var galleryImages      : ArrayList<String>     = arrayListOf(),
    @SerializedName("subtitle"           ) var subtitle           : String?               = null,
    @SerializedName("todaysUse"          ) var todaysUse          : String?               = null,
    @SerializedName("buildingType"       ) var buildingType       : String?               = null,
    @SerializedName("history"            ) var history            : String?               = null,
    @SerializedName("description"        ) var description        : String?               = null,
    @SerializedName("directions"         ) var directions         : String?               = null,
//    @SerializedName("sourceUrls"         ) var sourceUrls         : ArrayList<SourceUrls> = arrayListOf(),
    @SerializedName("sourceBooks"        ) var sourceBooks        : ArrayList<String>     = arrayListOf(),
//    @SerializedName("architects"         ) var architects         : ArrayList<Architects> = arrayListOf(),
//    @SerializedName("developers"         ) var developers         : ArrayList<Developers> = arrayListOf(),
    @SerializedName("absoluteURL"        ) var absoluteURL        : String?               = null

)

fun NetworkBuildingDetails.asDatabaseModel(): DatabaseBuildingDetails {
    return DatabaseBuildingDetails(
        id = id,
        name = name ?: "",
        city = city ?: "",
        feedImage = galleryImages[0],
    )
}
