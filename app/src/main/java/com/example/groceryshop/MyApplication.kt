package com.example.groceryshop

import android.app.Application
import com.example.groceryshop.database.AppDatabase

class MyApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
    }
}