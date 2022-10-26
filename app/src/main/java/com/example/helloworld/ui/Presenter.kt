package com.example.helloworld.ui

import com.example.helloworld.models.HelloModel

class Presenter(view: AppView) {
    //The link between the presenter and the view (MMainActivity) is done via our interface
    private var view: AppView? = null

    init {
        this.view = view
    }

    fun attachView(view: AppView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    //Simulate retrieving data from a database
    private fun getHelloModel() : HelloModel {
        return HelloModel("This.. Is.. MVP!", 100)
    }

    //Passing updated data from this presenter to the view
    fun onGetAppName() {
        view?.onGetAppName(getHelloModel().name)
    }
}