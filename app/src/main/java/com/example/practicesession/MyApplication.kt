package com.example.practicesession

import android.app.Application
import com.example.practicesession.di.component.ApplicationComponent
import com.example.practicesession.di.component.DaggerApplicationComponent
import com.example.practicesession.di.module.ApplicationModule

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}