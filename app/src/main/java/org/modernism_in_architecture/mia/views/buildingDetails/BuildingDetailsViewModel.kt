package org.modernism_in_architecture.mia.views.buildingDetails

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.modernism_in_architecture.mia.domain.BuildingDetails
import org.modernism_in_architecture.mia.repositories.BuildingDetailsRepository
import javax.inject.Inject

@HiltViewModel
class BuildingDetailsViewModel @Inject constructor(
    private val buildingDetailsRepository: BuildingDetailsRepository
) : ViewModel() {

    val buildingDetails = ObservableParcelable(BuildingDetails(1))

    fun getBuildingDetails(buildingId: Int) = buildingDetailsRepository.getBuildingDetails(buildingId)

    fun refreshBuildingDetails(buildingId: Int) = viewModelScope.launch(Dispatchers.IO) {
        buildingDetailsRepository.refreshBuildingDetails(buildingId)
    }

}