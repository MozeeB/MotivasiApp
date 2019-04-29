package com.mozeeb.motivasiapp.signup

interface SignUpContruct {
    interface View{
        fun onSignUpSuccess()
        fun onSignUpFailed()
        fun formValidate()
    }
    interface Presenter{
        fun SignUp(nama:String, username:String, email:String, password:String)
    }
}