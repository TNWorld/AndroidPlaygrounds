package com.example.di_module.di

import com.example.di_module.Car
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @CarScope
    fun providesCar() = Car()

}