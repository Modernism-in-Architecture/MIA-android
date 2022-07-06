package org.modernism_in_architecture.mia.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BuildingDetails(
    val id                 : Int,
    val name               : String?               = null,
    var yearOfConstruction : String?               = null,
    var city               : String?               = null,
    var feedImage          : String?               = null,
) : Parcelable