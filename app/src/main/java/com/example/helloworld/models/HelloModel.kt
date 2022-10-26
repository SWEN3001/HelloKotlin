package com.example.helloworld.models

class HelloModel(name: String, down: Int) {
    var name: String
    var downloads: Int

    init {
        this.name = name
        this.downloads = down
    }
}