package org.modernism_in_architecture.mia.views.architectsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.modernism_in_architecture.mia.repositories.ArchitectsListRepository
import javax.inject.Inject

@HiltViewModel
class ArchitectsListViewModel @Inject constructor(
    private val architectsListRepository: ArchitectsListRepository
) : ViewModel() {

    val data = architectsListRepository.architects

    init {
        viewModelScope.launch(Dispatchers.IO) {
            architectsListRepository.refreshArchitectsList()
        }
    }

}