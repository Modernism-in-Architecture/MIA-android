package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.database.DatabaseBuildingsListItem

data class NetworkBuildingsListItem(
    @SerializedName("id"                 ) var id                 : Int,
    @SerializedName("name"               ) var name               : String?               = null,
    @SerializedName("city"               ) var city               : String?               = null,
    @SerializedName("country"            ) var country            : String?               = null,
    @SerializedName("feedImage"          ) var feedImage          : String?               = null,
    @SerializedName("buildingType"       ) var buildingType       : String?               = null
)



fun List<NetworkBuildingsListItem>.asDatabaseModel(): List<DatabaseBuildingsListItem> {
    return map {
        DatabaseBuildingsListItem(
            id = it.id,
            name = it.name,
            city = it.city,
            country = it.country,
            feedImage = it.feedImage,
        )
    }
}
