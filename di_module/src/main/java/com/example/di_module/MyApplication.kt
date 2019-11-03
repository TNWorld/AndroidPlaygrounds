package com.example.di_module

import com.example.di_module.di.DaggerApplicationComponentClean
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponentClean = DaggerApplicationComponentClean.builder().application(this).build()
        applicationComponentClean.inject(this)
        return applicationComponentClean
    }
}