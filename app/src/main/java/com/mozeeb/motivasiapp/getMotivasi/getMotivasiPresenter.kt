package com.mozeeb.motivasiapp.getMotivasi

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.mozeeb.motivasiapp.GlobalActivity
import com.mozeeb.motivasiapp.model.ResponseMotivasi
import com.mozeeb.motivasiapp.model.TumbuhanItem

class getMotivasiPresenter(mode: getMotivasiContruct.View) : getMotivasiContruct.Presenter {

    var view: getMotivasiContruct.View? = null

    init {
        view = mode
    }


    override fun getMotivasi() {
        AndroidNetworking.get(GlobalActivity.BASE_URL + "getKata")
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(ResponseMotivasi::class.java, object : ParsedRequestListener<ResponseMotivasi> {
                override fun onResponse(response: ResponseMotivasi?) {
                    view?.showMotivasi(response?.tumbuhan as List<TumbuhanItem>)
                    view?.onSuccess()
                }

                override fun onError(anError: ANError?) {
                    view?.onFailed()
                }

            })
    }

}