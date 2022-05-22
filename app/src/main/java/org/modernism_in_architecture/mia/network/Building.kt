package org.modernism_in_architecture.mia.network

import com.squareup.moshi.Json

data class BuildingsResult(
    @Json(name = "data") val buildings_data: List<Building>? = null
)

data class Building(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "yearOfConstruction") val yearOfConstruction: String,
    @Json(name = "city") val city: String,
    @Json(name = "country") val country: String,
    @Json(name = "latitude") val latitude: Float,
    @Json(name = "longitude") val longitude: Float,
    @Json(name = "feedImage") val feedImage: String,
)
// ToDo: Add missing json values
// {,"developers":[{"id":1054,"lastName":"Aitken","firstName":"William Maxwell"}],"architects":[],"buildingType":"Administration building"},
