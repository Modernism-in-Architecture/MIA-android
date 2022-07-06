package org.modernism_in_architecture.mia.network.models


import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.network.models.NetworkBuildingsListItem


data class NetworkBuildingsList(
    @SerializedName("data" ) var networkBuildings : ArrayList<NetworkBuildingsListItem> = arrayListOf()
)
