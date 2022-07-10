package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName

class NetworkArchitectsList {
    @SerializedName("data" ) var networkArchitects : ArrayList<NetworkArchitectsListItem> = arrayListOf()
}