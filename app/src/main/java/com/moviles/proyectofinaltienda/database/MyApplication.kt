package com.moviles.proyectofinaltienda.database

import android.app.Application

class MyApplication: Application() {

    override  fun onCreate(){
        DatabaseManager.instance.initializeDb(applicationContext)
        super.onCreate()
    }
}