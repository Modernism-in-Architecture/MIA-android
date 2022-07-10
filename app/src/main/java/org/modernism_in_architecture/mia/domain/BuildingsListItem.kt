package org.modernism_in_architecture.mia.domain

data class BuildingsListItem(
    var id : Int,
    var name : String? = null,
    var city : String? = null,
    var country : String? = null,
    var feedImage : String? = null,
)