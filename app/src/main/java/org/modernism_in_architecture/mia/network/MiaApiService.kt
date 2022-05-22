package org.modernism_in_architecture.mia.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.modernism_in_architecture.mia.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://modernism-in-architecture.org/api/v1/"
private const val apiKey: String = BuildConfig.API_KEY

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MiaApiService {
    @Headers("Authorization: Token $apiKey", "Content-Type: application/json")
    @GET("buildings/")
    suspend fun getBuildings(): BuildingsResult
}

object MiaApi {
    val retrofitService: MiaApiService by lazy { retrofit.create(MiaApiService::class.java) }
}