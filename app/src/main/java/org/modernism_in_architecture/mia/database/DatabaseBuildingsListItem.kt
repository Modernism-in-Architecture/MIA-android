package org.modernism_in_architecture.mia.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.modernism_in_architecture.mia.domain.BuildingsListItem

@Entity
data class DatabaseBuildingsListItem(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val city: String?,
    val country: String?,
    val feedImage: String?,
)

fun List<DatabaseBuildingsListItem>.asDomainModel(): List<BuildingsListItem> {
    return map {
         BuildingsListItem(
            id = it.id,
            name = it.name,
            city = it.city,
            country = it.country,
            feedImage = it.feedImage,
        )
    }
}