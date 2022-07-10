package org.modernism_in_architecture.mia.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import org.modernism_in_architecture.mia.database.BuildingsDatabase
import org.modernism_in_architecture.mia.database.asDomainModel
import org.modernism_in_architecture.mia.domain.ArchitectsListItem
import org.modernism_in_architecture.mia.network.ArchitectsListService
import org.modernism_in_architecture.mia.network.models.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class ArchitectsListRepository @Inject constructor(
    private val networkService: ArchitectsListService,
    private val database: BuildingsDatabase
) {
    val architects: LiveData<List<ArchitectsListItem>> =
        Transformations.map(database.buildingsDao.getDatabaseArchitects()) {
            it.asDomainModel()
        }

    suspend fun refreshArchitectsList() {
        try {
            val data = networkService.getArchitectsList()
            database.buildingsDao.insertAllArchitects(data.networkArchitects.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}
