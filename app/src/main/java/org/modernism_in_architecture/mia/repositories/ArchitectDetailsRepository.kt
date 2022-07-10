package org.modernism_in_architecture.mia.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import org.modernism_in_architecture.mia.database.BuildingsDatabase
import org.modernism_in_architecture.mia.database.asDomainModel
import org.modernism_in_architecture.mia.domain.ArchitectDetails
import org.modernism_in_architecture.mia.network.ArchitectDetailsService
import org.modernism_in_architecture.mia.network.models.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class ArchitectDetailsRepository @Inject constructor(
    private val networkService: ArchitectDetailsService,
    private val database: BuildingsDatabase
) {

    fun getArchitectDetails(architectId: Int): LiveData<ArchitectDetails> {
        return Transformations.map(database.buildingsDao.getArchitectDetails(architectId)) {
            it?.asDomainModel()
        }
    }

    suspend fun refreshArchitectDetails(architectId: Int) {
        try {
            val data = networkService.getArchitectDetails(architectId)
            database.buildingsDao.insertArchitectDetails(data.networkArchitect.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}