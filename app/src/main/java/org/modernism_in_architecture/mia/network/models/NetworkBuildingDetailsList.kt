package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.network.models.NetworkBuildingDetails

data class NetworkBuildingDetailsList(
    @SerializedName("data" ) var networkBuilding : NetworkBuildingDetails = NetworkBuildingDetails(1)
)
