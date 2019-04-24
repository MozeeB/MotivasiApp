package com.mozeeb.motivasiapp.login2

import android.widget.EditText

interface LoginContruct2 {
    interface View{
        fun onSuccess(message:String)
        fun onFailed(message: String)
        fun showLoggingIn()
        fun ShowToastFormNotValid();

    }
    interface Presenter{
        fun doLogin(username:String, password:String)
        fun loginClicked(username: EditText, password: EditText)

    }
}