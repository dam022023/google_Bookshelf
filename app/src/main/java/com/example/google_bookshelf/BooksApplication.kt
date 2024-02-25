package com.example.google_bookshelf

import android.app.Application
import com.example.google_bookshelf.data.AppContainer
import com.example.google_bookshelf.data.DefaultAppContainer

class BooksApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}