package com.example.di_module.di

import com.example.di_module.DIMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityBuilder {

    @CarScope
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindDIMainActivity(): DIMainActivity
}