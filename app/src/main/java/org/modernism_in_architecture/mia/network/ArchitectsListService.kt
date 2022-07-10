package org.modernism_in_architecture.mia.network

import org.modernism_in_architecture.mia.network.models.NetworkArchitectsList
import retrofit2.http.GET
import retrofit2.http.Headers

interface ArchitectsListService {

    @Headers("Authorization: Token ${ApiSettings.API_KEY}", "Content-Type: application/json")
    @GET(ApiSettings.ARCHITECTS_LIST)
    suspend fun getArchitectsList(): NetworkArchitectsList
}