package com.mozeeb.motivasiapp

import android.app.Application
import com.androidnetworking.AndroidNetworking

class GlobalActivity : Application() {

    companion object {
        var BASE_URL:String = "http://192.168.9.99/motivasi/index.php/Api/"
    }

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)

    }
}