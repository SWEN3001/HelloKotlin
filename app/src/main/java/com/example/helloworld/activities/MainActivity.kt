package com.example.helloworld.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.helloworld.R
import com.example.helloworld.ui.HelloViewModel

//Note that we removed the AppView interface and the Presenter class
//We have completely decoupled the Activity from the App logic
class MainActivity : AppCompatActivity() {
    //MVVM - Model View ViewModel Pattern
    //Model [HelloModel] - Data
    //View [MainActivity containing TextView & Button] - UI
    //ViewModel [HelloViewModel] - Logic

    var button: Button? = null
    var textView : TextView? = null
    var viewModel: HelloViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button3)
        textView = findViewById(R.id.textView)

        //Initialize the ViewModel
        viewModel = ViewModelProvider(this)[HelloViewModel::class.java]

        //Add a click listener to the button
        button?.setOnClickListener(View.OnClickListener {
            //Call to update the data in the view model
            //The Activity no longer contains the logic binding the view to the model
            viewModel!!.onGetAppName()
        })

        //Observing the data for any changes
        //Once a change is detected, the UI is updated
        viewModel!!.mutableLiveData.observe(this) {
            textView?.text = it
        }
    }
}