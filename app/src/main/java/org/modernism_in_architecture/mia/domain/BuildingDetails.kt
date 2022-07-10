package org.modernism_in_architecture.mia.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import org.modernism_in_architecture.mia.network.models.NetworkBuildingDetails

@Parcelize
data class BuildingDetails(
    val id: Int,
    val name: String? = null,
    val feedImage: String? = null,
    val todaysUse: String? = null,
    val buildingType: String? = null,
    val address: String? = null,
    val zipCode: String? = null,
    val city: String? = null,
    val country: String? = null,
    val latitude: Double? = null,
    val longitude: Double ? = null,
    val history: String? = null,
    val description: String? = null,
    val yearOfConstruction: String? = null,
    val absoluteURL: String? = null,
    val galleryImages: @RawValue List<String>? = null,
    val architects: @RawValue ArrayList<NetworkBuildingDetails.Architect>? = null,
) : Parcelable