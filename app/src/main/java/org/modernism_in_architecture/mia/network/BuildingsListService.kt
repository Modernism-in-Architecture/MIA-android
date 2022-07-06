package org.modernism_in_architecture.mia.network

import org.modernism_in_architecture.mia.network.models.NetworkBuildingsList
import retrofit2.http.GET
import retrofit2.http.Headers

interface BuildingsListService {

    @Headers("Authorization: Token ${ApiSettings.API_KEY}", "Content-Type: application/json")
    @GET(ApiSettings.BUILDINGS_LIST)
    suspend fun getBuildingsList(): NetworkBuildingsList

}