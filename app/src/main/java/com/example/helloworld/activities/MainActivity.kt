package com.example.helloworld.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.R
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.ui.HelloViewModel

//Note that we removed the AppView interface and the Presenter class
//We have completely decoupled the Activity from the App logic
class MainActivity : AppCompatActivity() {
    //MVVM - Model View ViewModel Pattern
    //Model [HelloModel] - Data
    //View [MainActivity containing TextView & Button] - UI
    //ViewModel [HelloViewModel] - Logic

    //Removed view variables
    private var viewModel: HelloViewModel? = null

    //View binding variable - https://developer.android.com/topic/libraries/view-binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Bind view
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Set the visible view to the bound view
        setContentView(binding.root)

        //Initialize the ViewModel
        viewModel = ViewModelProvider(this)[HelloViewModel::class.java]

        //View binding will now observe and automatically update the UI when the data changes
        binding.viewModel = viewModel

        //Lifecycle owner is required for view binding to work
        binding.lifecycleOwner = this
    }
}