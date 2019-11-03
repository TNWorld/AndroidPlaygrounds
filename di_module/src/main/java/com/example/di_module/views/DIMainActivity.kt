package com.example.di_module.views

import android.os.Bundle
import android.widget.Toast
import com.example.di_module.logic.Car
import com.example.di_module.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

//Have to inherit from dagger's AppCompatActivity
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
    }
}
