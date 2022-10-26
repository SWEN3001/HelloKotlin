package com.example.helloworld.ui

interface AppView {
    //The link between the presenter and the view
    fun onGetAppName(name: String)
}