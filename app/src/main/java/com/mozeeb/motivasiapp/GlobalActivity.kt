package com.mozeeb.motivasiapp

import android.app.Application
import com.androidnetworking.AndroidNetworking

class GlobalActivity : Application() {

    companion object {
        var BASE_URL:String = "http://192.168.70.129/api_motivasi/"
    }

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext());

    }
}