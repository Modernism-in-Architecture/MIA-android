package org.modernism_in_architecture.mia.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import org.modernism_in_architecture.mia.database.BuildingsDatabase
import org.modernism_in_architecture.mia.database.asDomainModel
import org.modernism_in_architecture.mia.domain.BuildingsListItem
import org.modernism_in_architecture.mia.network.BuildingsListService
import org.modernism_in_architecture.mia.network.models.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class BuildingsListRepository @Inject constructor(
    private val networkService: BuildingsListService,
    private val database: BuildingsDatabase
) {

    val buildings: LiveData<List<BuildingsListItem>> =
        Transformations.map(database.buildingsDao.getDatabaseBuildings()) {
            it.asDomainModel()
        }

    suspend fun refreshBuildingsList() {
        try {
            val data = networkService.getBuildingsList()
            database.buildingsDao.insertAllBuildings(data.networkBuildings.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}
