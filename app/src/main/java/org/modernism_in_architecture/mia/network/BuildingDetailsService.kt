package org.modernism_in_architecture.mia.network

import org.modernism_in_architecture.mia.network.models.NetworkBuildingDetailsList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface BuildingDetailsService {

    @Headers("Authorization: Token ${ApiSettings.API_KEY}", "Content-Type: application/json")
    @GET("${ApiSettings.BUILDINGS_LIST}{id}/")
    suspend fun getBuildingDetails(@Path("id") buildingId: Int): NetworkBuildingDetailsList

}