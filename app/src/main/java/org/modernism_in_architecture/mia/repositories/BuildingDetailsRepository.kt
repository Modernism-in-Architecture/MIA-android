package org.modernism_in_architecture.mia.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import org.modernism_in_architecture.mia.database.BuildingsDatabase
import org.modernism_in_architecture.mia.database.asDomainModel
import org.modernism_in_architecture.mia.domain.BuildingDetails
import org.modernism_in_architecture.mia.network.BuildingDetailsService
import org.modernism_in_architecture.mia.network.models.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class BuildingDetailsRepository @Inject constructor(
    private val networkService: BuildingDetailsService,
    private val database: BuildingsDatabase
) {

    fun getBuildingDetails(buildingId: Int): LiveData<BuildingDetails> {
        return Transformations.map(database.buildingsDao.getBuildingDetails(buildingId)) {
            it?.asDomainModel()
        }
    }


    suspend fun refreshBuildingDetails(buildingId: Int) {
        try {
            val data = networkService.getBuildingDetails(buildingId)
            database.buildingsDao.insertBuildingDetails(data.networkBuilding.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}


