package org.modernism_in_architecture.mia.network.models

import com.google.gson.annotations.SerializedName
import org.modernism_in_architecture.mia.network.models.NetworkArchitectDetails

data class NetworkArchitectDetailsList(
    @SerializedName("data" ) var networkArchitect : NetworkArchitectDetails = NetworkArchitectDetails(1)
)