package org.modernism_in_architecture.mia.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.modernism_in_architecture.mia.domain.BuildingDetails
import org.modernism_in_architecture.mia.network.models.NetworkBuildingDetails

@Entity
data class DatabaseBuildingDetails(
    @PrimaryKey
    val id: Int,
    val name: String,
    val feedImage: String,
    val todaysUse: String,
    val buildingType: String,
    val address: String,
    val zipCode: String,
    val city: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val history: String,
    val description: String,
    val yearOfConstruction: String,
    val absoluteURL: String,
    @TypeConverters(StringListConverter::class)
    val galleryImages: List<String>,
    @TypeConverters(ArchitectConverter::class)
    val architects: ArrayList<NetworkBuildingDetails.Architect>,
)

fun DatabaseBuildingDetails.asDomainModel(): BuildingDetails {
    return BuildingDetails(
        id = id,
        name = name,
        feedImage = feedImage,
        todaysUse = todaysUse,
        buildingType = buildingType,
        address = address,
        zipCode = zipCode,
        city = city,
        country = country,
        latitude = latitude,
        longitude = longitude,
        history = history,
        description = description,
        yearOfConstruction = yearOfConstruction,
        absoluteURL = absoluteURL,
        galleryImages = galleryImages,
        architects = architects,
    )
}