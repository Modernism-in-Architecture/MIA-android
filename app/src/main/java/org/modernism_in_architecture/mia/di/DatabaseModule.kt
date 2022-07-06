package org.modernism_in_architecture.mia.di

import android.content.Context
import androidx.room.Room
import org.modernism_in_architecture.mia.database.BuildingsDao
import org.modernism_in_architecture.mia.database.BuildingsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): BuildingsDatabase {
        return Room.databaseBuilder(
            appContext,
            BuildingsDatabase::class.java,
            "Buildings"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(buildingsDatabase: BuildingsDatabase): BuildingsDao {
        return buildingsDatabase.buildingsDao
    }

}