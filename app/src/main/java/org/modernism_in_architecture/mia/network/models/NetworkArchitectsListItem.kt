package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.database.DatabaseArchitectsListItem

data class NetworkArchitectsListItem(
    @SerializedName("id") var id : Int,
    @SerializedName("lastName") var lastName : String? = null,
    @SerializedName("firstName") var firstName : String? = null,
)


fun List<NetworkArchitectsListItem>.asDatabaseModel(): List<DatabaseArchitectsListItem> {
    return map {
        DatabaseArchitectsListItem(
            id = it.id,
            lastName = it.lastName,
            firstName = it.firstName,
        )
    }
}