package com.mozeeb.motivasiapp.tambahMotivasi

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.mozeeb.motivasiapp.GlobalActivity
import org.json.JSONObject

class TambahPresenter(model : TambahContruct.View) : TambahContruct.Presenter {


    var view :TambahContruct.View? = null

    init {
        view = model
    }

    override fun postMotivasi(judul: String, motivasi: String, penulis: String, tanggal: String) {

        if (judul.length > 0 && motivasi.length > 0 && penulis.length > 0 && tanggal.length > 0){

            AndroidNetworking.post(GlobalActivity.BASE_URL + "tambahMotivasi")
                .setPriority(Priority.HIGH)
                .addBodyParameter("judul", judul)
                .addBodyParameter("motivasi", motivasi)
                .addBodyParameter("penulis", penulis)
                .addBodyParameter("tanggal", tanggal)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        view?.onSuccess()

                    }

                    override fun onError(anError: ANError?) {
                        view?.onFailed()
                    }
                })
        }else{
            view?.formValidate()
        }

    }



}