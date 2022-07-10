package org.modernism_in_architecture.mia.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.modernism_in_architecture.mia.domain.ArchitectsListItem

@Entity
data class DatabaseArchitectsListItem(
    @PrimaryKey
    val id: Int,
    val lastName: String?,
    val firstName: String?,
)

fun List<DatabaseArchitectsListItem>.asDomainModel(): List<ArchitectsListItem> {
    return map {
        ArchitectsListItem(
            id = it.id,
            lastName = it.lastName,
            firstName = it.firstName,
        )
    }
}







