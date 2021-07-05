package com.mozeeb.motivasiapp

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.onesignal.OneSignal

class GlobalActivity : Application() {

    companion object {
        var BASE_URL:String = "http://192.168.1.27/motivasi/index.php/Api/"
    }

    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)

        // OneSignal Initialization
        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .init()

    }
}