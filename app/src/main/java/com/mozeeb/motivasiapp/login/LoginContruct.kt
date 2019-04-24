package com.mozeeb.motivasiapp.login

import android.widget.EditText

interface LoginContruct {
    interface View{
       fun goToLogin()
        fun goToRegister()

    }
    interface Presenter{
        fun goToLogin()
        fun goToRegister()

    }
}