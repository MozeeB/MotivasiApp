package com.mozeeb.motivasiapp.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mozeeb.motivasiapp.R
import com.mozeeb.motivasiapp.login2.LoginActivity2
import com.mozeeb.motivasiapp.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() , LoginContruct.View {

    lateinit var presenter: LoginContruct.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        signin.setOnClickListener {
           presenter.goToLogin()
        }

        signup.setOnClickListener {
            presenter.goToRegister()
        }
    }


    override fun goToLogin() {
        val intent = Intent(this@LoginActivity, LoginActivity2::class.java)
        startActivity(intent)

    }

    override fun goToRegister() {
        val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
        startActivity(intent)
    }
}
