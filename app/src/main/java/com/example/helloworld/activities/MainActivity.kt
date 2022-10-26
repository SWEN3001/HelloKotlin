package com.example.helloworld.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.helloworld.R
import com.example.helloworld.models.HelloModel

class MainActivity : AppCompatActivity() {
    //MVC - Model View Controller Pattern
    //View [textView] - UI
    //Controller [MainActivity] - Logic
    //Model [HelloModel] - Data
    var button: Button? = null
    var textView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button3)
        textView = findViewById(R.id.textView)
        //Add a click listener to the button
        button?.setOnClickListener(View.OnClickListener {
            textView?.text = getInfoFromModel().name + " was downloaded: " + getInfoFromModel().downloads + " times"
        })
    }
    //Simulate retrieving data from our model
    fun getInfoFromModel(): HelloModel {
        return HelloModel("Kotch ih Code", 10)
    }

    //function that may be used in place of the onclick listener
    fun showInfo(view: View){
        textView?.text = getInfoFromModel().name + " was downloaded: " + getInfoFromModel().downloads + " times"
    }

}