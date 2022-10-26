package com.example.helloworld.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloworld.models.HelloModel

//Notice that the ViewModel class extends ViewModel
class HelloViewModel : ViewModel() {
    //LiveData variables that will be observed by the UI
    //Livedata is immutable, and is used for data we only wish to observe
    lateinit var liveData: LiveData<String>
    //MutableLiveData is mutable, and is used for data that we expect to edit
    var mutableLiveData: MutableLiveData<String> = MutableLiveData()

    //Simulate retrieving data from a database
    fun getHelloModel() : HelloModel {
        return HelloModel("MVVM has entered the chat...", 100)
    }

    //Modify our live data
    fun onGetAppName() {
        mutableLiveData.value = getHelloModel().name
    }
}