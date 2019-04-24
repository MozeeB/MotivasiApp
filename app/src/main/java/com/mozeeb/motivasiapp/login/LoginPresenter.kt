package com.mozeeb.motivasiapp.login

class LoginPresenter (model : LoginContruct.View): LoginContruct.Presenter {

    var viewmodel : LoginContruct.View? = null

    init {
        viewmodel = model
    }


    override fun goToLogin() {
        viewmodel?.goToLogin()

    }

    override fun goToRegister() {
        viewmodel?.goToRegister()
    }
}