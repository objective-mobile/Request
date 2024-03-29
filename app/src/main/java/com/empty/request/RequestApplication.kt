package com.empty.request

import android.app.Application
import com.empty.openai.di.openAiModule
import com.empty.request.presentation.requestModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RequestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(
                openAiModule,
                requestModule
            )
        }
    }
}