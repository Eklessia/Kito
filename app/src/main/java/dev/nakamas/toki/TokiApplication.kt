package dev.nakamas.toki

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.random.Random

class TokiApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Unique initialization of Dependency Injection library to allow the use of application context
        startKoin { androidContext(this@TokiApplication) }

        val nightMode = when (Random.nextBoolean()) {
            true -> AppCompatDelegate.MODE_NIGHT_YES
            false -> AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}