package com.example.helloworld.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.helloworld.R
import com.example.helloworld.models.HelloModel
import com.example.helloworld.ui.AppView
import com.example.helloworld.ui.Presenter

//Note that we are now implementing the AppView interface
class MainActivity : AppCompatActivity(), AppView {
    //MVP - Model View Presenter Pattern
    //Model [HelloModel] - Data
    //View [MainActivity containing TextView & Button] - UI
    //Presenter [Presenter] - Logic

    var button: Button? = null
    var textView : TextView? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button3)
        textView = findViewById(R.id.textView)

        //Initialize the presenter
        //We pass it the view (this) so that it can update the widgets within the view
        presenter = Presenter(this)

        //Add a click listener to the button
        button?.setOnClickListener(View.OnClickListener {
            //Call the presenter to retrieve/update the data
            //The Activity no longer contains the logic for accessing the data
            presenter!!.onGetAppName()
        })


    }

    //function that may be used in place of the onclick listener
    fun showInfo(view: View){
        //textView?.text = getInfoFromModel().name + " was downloaded: " + getInfoFromModel().downloads + " times"
        presenter?.onGetAppName()
    }

    //Override the function from the AppView interface
    //Establishing the link between our view and the presenter
    override fun onGetAppName(name: String) {
        textView?.text = name
    }

}