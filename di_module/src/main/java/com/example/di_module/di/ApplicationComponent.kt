package com.example.di_module.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    //--->Component.Builder
    //Here we can create a builder that will bind the main activity directly to this component Instance
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DaggerApplication): Builder
        fun build(): ApplicationComponent
    }

    //fun inject(app: MyApplication)
    override fun inject(instance: DaggerApplication)
}

