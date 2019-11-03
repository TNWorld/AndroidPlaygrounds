package com.example.di_module

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DIMainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var car : Car

    //--->di/ApplicationComponent--->@Component.Builder
    //There is even a way to avoid having to use any of the above methods
    //We do this by doing using the @Component.Builder annotation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dimain)
        car.toast()
        Toast.makeText(this,"This is a toast",Toast.LENGTH_SHORT).show()
//        getDependencies() These are commented out as we are actually injecting via the Component.Builder
//        getDependenciesBuild()
    }

//    This is simplest way to inject a component graph into a class
//    private fun getDependencies() {
//        DaggerApplicationComponent
//            .create()
//            .inject(this)
//    }
//
//    //Using the builder method you can now pass arguments to the modules contructors
//    private fun getDependenciesBuild() {
//        DaggerApplicationComponent.builder()
//            //.moduleName(ModuleName(arg : Arg))
//            .applicationModule(ApplicationModule()) //However we don't even need this anymore
//            .build()
//            .inject(this)
//    }
}
