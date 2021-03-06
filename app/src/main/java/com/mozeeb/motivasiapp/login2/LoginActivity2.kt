package com.mozeeb.motivasiapp.login2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mozeeb.motivasiapp.getMotivasi.MainActivity
import com.mozeeb.motivasiapp.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity2 : AppCompatActivity() , LoginContruct2.View{

    lateinit var presenter2: LoginPresenter2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        presenter2 = LoginPresenter2(this)

        btn_login_login.setOnClickListener {
            presenter2.doLogin(edtUserLogin.text.toString(), edtPassLogin.text.toString())
        }


    }

    override fun onSuccess(message: String) {
        Toasty.success(this, "Login Successfully!", Toasty.LENGTH_LONG).show()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onFailed(message: String) {
        Toasty.error(this, "Login Failed!", Toasty.LENGTH_LONG).show()
    }

    override fun showLoggingIn() {
        Toasty.success(this, "Login Successfully!", Toasty.LENGTH_LONG).show()

    }

    override fun ShowToastFormNotValid() {
        Toasty.error(this, "Username and Password cannot be empty!", Toasty.LENGTH_LONG).show();

    }
}
