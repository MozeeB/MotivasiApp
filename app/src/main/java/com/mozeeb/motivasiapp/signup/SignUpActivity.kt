package com.mozeeb.motivasiapp.signup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mozeeb.motivasiapp.R
import com.mozeeb.motivasiapp.login2.LoginActivity2
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() , SignUpContruct.View {

    lateinit var presenter: SignUpPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        presenter = SignUpPresenter(this)

        btn_signup.setOnClickListener {
            presenter.SignUp(edt_nama_regis.text.toString(),
                edt_username_regis.text.toString(),
                edt_email_regis.text.toString(), edt_pass_regis.text.toString())
        }


    }

    override fun onSignUpSuccess() {
        Toasty.success(this, "Create Account Is Successfully!", Toasty.LENGTH_LONG).show()
        var intent = Intent(this, LoginActivity2::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSignUpFailed() {
        Toasty.error(this, "Create Account Is Failed!", Toasty.LENGTH_LONG).show()

    }

    override fun formValidate() {
        Toasty.error(this, "Form Must Be Valid!", Toasty.LENGTH_LONG).show()

    }
}
