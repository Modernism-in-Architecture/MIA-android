package org.modernism_in_architecture.mia.views.buildingsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.modernism_in_architecture.mia.repositories.BuildingsListRepository
import javax.inject.Inject

@HiltViewModel
class BuildingsListViewModel @Inject constructor(
    private val buildingsListRepository: BuildingsListRepository
) : ViewModel() {

    val data = buildingsListRepository.buildings

    init {
        viewModelScope.launch(Dispatchers.IO) {
            buildingsListRepository.refreshBuildingsList()
        }
    }

}

