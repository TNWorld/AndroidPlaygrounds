package com.example.myreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Will be a list of all the activities/projects that can be viewed, will act as the entry point to
//each miniproject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
