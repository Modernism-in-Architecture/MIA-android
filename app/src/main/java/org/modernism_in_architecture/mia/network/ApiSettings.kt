package org.modernism_in_architecture.mia.network

import org.modernism_in_architecture.mia.BuildConfig

object ApiSettings {

    const val API_KEY: String = BuildConfig.API_KEY
    const val BASE_URL = "https://modernism-in-architecture.org/api/"
    private const val V1 = "v1/"
    const val BUILDINGS_LIST = V1 + "buildings/"
    const val ARCHITECTS_LIST = V1 + "architects/"

}