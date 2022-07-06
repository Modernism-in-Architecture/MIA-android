package org.modernism_in_architecture.mia

import dagger.hilt.android.HiltAndroidApp
import android.app.Application
import timber.log.Timber


@HiltAndroidApp
class MiaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
