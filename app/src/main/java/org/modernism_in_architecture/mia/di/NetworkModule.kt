package org.modernism_in_architecture.mia.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.modernism_in_architecture.mia.BuildConfig
import org.modernism_in_architecture.mia.network.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    private val gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(ApiSettings.BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideBuildingListService(retrofit: Retrofit): BuildingsListService =
        retrofit.create(BuildingsListService::class.java)

    @Provides
    @Singleton
    fun provideBuildingDetailsService(retrofit: Retrofit): BuildingDetailsService =
        retrofit.create(BuildingDetailsService::class.java)

    @Provides
    @Singleton
    fun provideArchitectsListService(retrofit: Retrofit): ArchitectsListService =
        retrofit.create(ArchitectsListService::class.java)

    @Provides
    @Singleton
    fun provideArchitectDetailsService(retrofit: Retrofit): ArchitectDetailsService =
        retrofit.create(ArchitectDetailsService::class.java)
}