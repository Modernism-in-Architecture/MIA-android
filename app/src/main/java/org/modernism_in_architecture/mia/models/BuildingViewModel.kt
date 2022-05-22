package org.modernism_in_architecture.mia.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import org.modernism_in_architecture.mia.network.BuildingsResult
import org.modernism_in_architecture.mia.network.MiaApi

enum class MiaApiStatus { LOADING, ERROR, DONE }

class BuildingViewModel : ViewModel() {

    private val _status = MutableLiveData<MiaApiStatus>()

    val status: LiveData<MiaApiStatus> = _status

    private val _buildings = MutableLiveData<BuildingsResult>()

    val buildings: LiveData<BuildingsResult> = _buildings

    init {
        getBuildings()
    }

    private fun getBuildings() {

        viewModelScope.launch {
            _status.value = MiaApiStatus.LOADING
            try {
                _buildings.value = MiaApi.retrofitService.getBuildings()
                _status.value = MiaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MiaApiStatus.ERROR
            }
        }
    }
}