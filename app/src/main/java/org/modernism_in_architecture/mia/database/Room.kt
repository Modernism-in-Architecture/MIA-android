package org.modernism_in_architecture.mia.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BuildingsDao {

    // building list
    @Query("select * from DatabaseBuildingsListItem")
    fun getDatabaseBuildings(): LiveData<List<DatabaseBuildingsListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(buildings: List<DatabaseBuildingsListItem>)

    // single building
    @Query("select * from DatabaseBuildingDetails WHERE id LIKE :buildingId")
    fun getBuildingDetails(buildingId: Int): LiveData<DatabaseBuildingDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuildingDetails(databaseBuildingDetails: DatabaseBuildingDetails)
}

@Database(entities = [DatabaseBuildingsListItem::class, DatabaseBuildingDetails::class], version = 1)
abstract class BuildingsDatabase : RoomDatabase() {
    abstract val buildingsDao: BuildingsDao
}