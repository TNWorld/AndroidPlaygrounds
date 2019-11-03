package com.example.di_module.di

import com.example.di_module.logic.Car
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @CarScope
    @Provides
    fun providesCar() = Car()
}