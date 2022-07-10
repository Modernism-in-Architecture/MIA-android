package org.modernism_in_architecture.mia.views.architectDetails

import androidx.databinding.ObservableParcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.modernism_in_architecture.mia.domain.ArchitectDetails

import org.modernism_in_architecture.mia.repositories.ArchitectDetailsRepository
import javax.inject.Inject

@HiltViewModel
class ArchitectDetailsViewModel @Inject constructor(
    private val architectDetailsRepository: ArchitectDetailsRepository
) : ViewModel() {

    val architectDetails = ObservableParcelable(ArchitectDetails(1))

    fun getArchitectDetails(architectId: Int) = architectDetailsRepository.getArchitectDetails(architectId)

    fun refreshArchitectDetails(architectId: Int) = viewModelScope.launch(Dispatchers.IO) {
        architectDetailsRepository.refreshArchitectDetails(architectId)
    }

}