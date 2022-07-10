package org.modernism_in_architecture.mia.network

import org.modernism_in_architecture.mia.network.models.NetworkArchitectDetailsList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ArchitectDetailsService {

    @Headers("Authorization: Token ${ApiSettings.API_KEY}", "Content-Type: application/json")
    @GET("${ApiSettings.ARCHITECTS_LIST}{id}/")
    suspend fun getArchitectDetails(@Path("id") architectId: Int): NetworkArchitectDetailsList

}