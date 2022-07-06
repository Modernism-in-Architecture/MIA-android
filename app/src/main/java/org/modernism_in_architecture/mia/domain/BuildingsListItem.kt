package org.modernism_in_architecture.mia.domain

//import com.google.gson.annotations.SerializedName
//import org.modernism_in_architecture.mia.models.Architects
//import org.modernism_in_architecture.mia.models.Developers

data class BuildingsListItem(
    val id                 : Int,
    val name               : String?               = null,
    var yearOfConstruction : String?               = null,
    var city               : String?               = null,
    var country            : String?               = null,
    var latitude           : Double?               = null,
    var longitude          : Double?               = null,
    var feedImage          : String?               = null,
//    @SerializedName("developers"         ) var developers         : ArrayList<Developers> = arrayListOf(),
//    @SerializedName("architects"         ) var architects         : ArrayList<Architects> = arrayListOf(),
//    @SerializedName("buildingType"       ) var buildingType       : String?               = null
)