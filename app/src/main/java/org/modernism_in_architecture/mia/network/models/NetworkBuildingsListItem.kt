package org.modernism_in_architecture.mia.network.models

import android.util.Log
import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.database.DatabaseBuildingsListItem
//import org.modernism_in_architecture.mia.models.Architects
//import org.modernism_in_architecture.mia.models.Developers

data class NetworkBuildingsListItem(
    @SerializedName("id"                 ) var id                 : Int,
    @SerializedName("name"               ) var name               : String?               = null,
    @SerializedName("yearOfConstruction" ) var yearOfConstruction : String?               = null,
    @SerializedName("city"               ) var city               : String?               = null,
    @SerializedName("country"            ) var country            : String?               = null,
    @SerializedName("latitude"           ) var latitude           : Double?               = null,
    @SerializedName("longitude"          ) var longitude          : Double?               = null,
    @SerializedName("feedImage"          ) var feedImage          : String?               = null,
//    @SerializedName("developers"         ) var developers         : ArrayList<Developers> = arrayListOf(),
//    @SerializedName("architects"         ) var architects         : ArrayList<Architects> = arrayListOf(),
    @SerializedName("buildingType"       ) var buildingType       : String?               = null
)



fun List<NetworkBuildingsListItem>.asDatabaseModel(): List<DatabaseBuildingsListItem> {
    return map {
        it.id?.let { it1 ->
            DatabaseBuildingsListItem(
                id = it1,
                name = it.name,
                city = it.city,
                feedImage = it.feedImage,
            )
        }!!
    }
}
