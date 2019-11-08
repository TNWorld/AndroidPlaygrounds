package com.example.di_module

import com.example.di_module.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        applicationComponent.inject(this)
        return applicationComponent
    }
}