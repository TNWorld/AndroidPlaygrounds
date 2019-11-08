package com.example.databinding_module

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding_module.databinding.ActivityDatabindingMainBinding


class DatabindingMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityDatabindingMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_main)
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        binding.lifecycleOwner = this
        binding.viewmodel = ViewModel(ThingA(),ThingB(),clipboard)
    }
}
