package org.modernism_in_architecture.mia.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import org.modernism_in_architecture.mia.network.models.NetworkArchitectDetails

@Parcelize
data class ArchitectDetails (
    val id: Int,
    val lastName: String? = null,
    val firstName: String? = null,
    val birthDay: String? = null,
    val birthPlace: String? = null,
    val birthCountry: String? = null,
    val deathDay: String? = null,
    val deathPlace: String? = null,
    val deathCountry: String? = null,
    val description: String? = null,
    val absoluteURL: String ? = null,
    val relatedBuildings: @RawValue ArrayList<NetworkArchitectDetails.ArchitectBuilding>? = null,
) : Parcelable
