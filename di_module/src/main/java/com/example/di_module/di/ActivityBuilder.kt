package com.example.di_module.di

import com.example.di_module.views.DIMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @CarScope
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindDIMainActivity(): DIMainActivity

    @CarScope
    @ContributesAndroidInjector(modules = [ApplicationModule::class])
    abstract fun bindDISMainActivity(): DISMainActivity
}