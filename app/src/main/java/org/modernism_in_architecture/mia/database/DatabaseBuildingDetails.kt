package org.modernism_in_architecture.mia.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.modernism_in_architecture.mia.domain.BuildingDetails

@Entity
data class DatabaseBuildingDetails constructor(
    @PrimaryKey
    val id: Int,
    val name: String,
    val city: String,
    val feedImage: String,
)

fun DatabaseBuildingDetails.asDomainModel(): BuildingDetails {
    return BuildingDetails(
        id = id,
        name = name,
        city = city,
        feedImage = feedImage,
    )
}