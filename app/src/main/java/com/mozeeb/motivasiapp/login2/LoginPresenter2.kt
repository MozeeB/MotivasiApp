package com.mozeeb.motivasiapp.login2

import android.widget.EditText
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.mozeeb.motivasiapp.GlobalActivity
import org.json.JSONObject

class LoginPresenter2 (model : LoginContruct2.View) : LoginContruct2.Presenter {

    var viewmodel : LoginContruct2.View? = null

    init {
        viewmodel = model
    }

    override fun doLogin(username: String, password: String) {

        var json:JSONObject = JSONObject()
        json.put("username", username)
        json.put("password", password)

        AndroidNetworking.post(GlobalActivity.BASE_URL + "login")
            .setPriority(Priority.HIGH)
            .addBodyParameter(json)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    viewmodel?.onSuccess(response.toString())


                }

                override fun onError(anError: ANError?) {
                    viewmodel?.onFailed(anError.toString())
                }
            })
    }

    override fun loginClicked(username: EditText, password: EditText) {
        if (username.length() > 0 ){
            viewmodel?.showLoggingIn()
        }else{
            viewmodel?.ShowToastFormNotValid()
        }
    }
}