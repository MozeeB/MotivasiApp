package com.mozeeb.motivasiapp.signup

import android.util.Patterns
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.mozeeb.motivasiapp.GlobalActivity
import org.json.JSONObject

class SignUpPresenter(model: SignUpContruct.View) :SignUpContruct.Presenter {


    var view: SignUpContruct.View? = null

    init {

        view = model
    }

    override fun SignUp(nama: String, username: String, email: String, password: String) {

        if (nama.length > 0 && username.length > 0 && email.length > 0 &&
            Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 0) {


            AndroidNetworking.post(GlobalActivity.BASE_URL + "register")
                .setPriority(Priority.HIGH)
                .addBodyParameter("nama", nama)
                .addBodyParameter("username", username)
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener {
                    override fun onResponse(response: JSONObject?) {
                        view?.onSignUpSuccess()
                    }

                    override fun onError(anError: ANError?) {
                        view?.onSignUpFailed()
                    }
                })
        }else{
            view?.formValidate()
        }

    }

}