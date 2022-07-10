package org.modernism_in_architecture.mia.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.modernism_in_architecture.mia.domain.ArchitectDetails
import org.modernism_in_architecture.mia.network.models.NetworkArchitectDetails


@Entity
data class DatabaseArchitectDetails(
    @PrimaryKey
    val id: Int,
    val lastName: String,
    val firstName: String,
    val birthDay: String,
    val birthPlace: String,
    val birthCountry: String,
    val deathDay: String,
    val deathPlace: String,
    val deathCountry: String,
    val description: String,
    val absoluteURL: String,
    @TypeConverters(RelatedBuildingConverter::class)
    val relatedBuildings: ArrayList<NetworkArchitectDetails.ArchitectBuilding>,
)

fun DatabaseArchitectDetails.asDomainModel(): ArchitectDetails {
    return ArchitectDetails(
        id = id,
        lastName = lastName,
        firstName = firstName,
        birthDay = birthDay,
        birthPlace = birthPlace,
        birthCountry = birthCountry,
        deathDay = deathDay,
        deathPlace = deathPlace,
        deathCountry = deathCountry,
        description = description,
        absoluteURL = absoluteURL,
        relatedBuildings = relatedBuildings,
    )
}
