package com.mozeeb.motivasiapp.signup

interface SignUpContruct {
    interface View{
        fun onSignUpSuccess()
        fun onSignUpFailed()
    }
}