package org.modernism_in_architecture.mia.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BuildingsDao {

    // buildings list
    @Query("SELECT * FROM DatabaseBuildingsListItem ORDER BY id DESC")
    fun getDatabaseBuildings(): LiveData<List<DatabaseBuildingsListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllBuildings(buildings: List<DatabaseBuildingsListItem>)

    // single building
    @Query("SELECT * FROM DatabaseBuildingDetails WHERE id LIKE :buildingId")
    fun getBuildingDetails(buildingId: Int): LiveData<DatabaseBuildingDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuildingDetails(databaseBuildingDetails: DatabaseBuildingDetails)

    // architects list
    @Query("SELECT * FROM DatabaseArchitectsListItem")
    fun getDatabaseArchitects(): LiveData<List<DatabaseArchitectsListItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArchitects(architects: List<DatabaseArchitectsListItem>)

    // single architect
    @Query("SELECT * FROM DatabaseArchitectDetails WHERE id LIKE :architectId")
    fun getArchitectDetails(architectId: Int): LiveData<DatabaseArchitectDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArchitectDetails(databaseArchitectDetails: DatabaseArchitectDetails)
}

@Database(entities = [DatabaseBuildingsListItem::class, DatabaseBuildingDetails::class, DatabaseArchitectsListItem:: class, DatabaseArchitectDetails::class], version = 1)
@TypeConverters(ArchitectConverter::class, RelatedBuildingConverter::class, StringListConverter::class)
abstract class BuildingsDatabase : RoomDatabase() {
    abstract val buildingsDao: BuildingsDao
}