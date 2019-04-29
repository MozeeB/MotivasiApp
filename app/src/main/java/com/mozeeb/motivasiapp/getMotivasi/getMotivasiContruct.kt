package com.mozeeb.motivasiapp.getMotivasi

import com.mozeeb.motivasiapp.model.TumbuhanItem

interface getMotivasiContruct {
    interface View{
        fun onSuccess()
        fun onFailed()
        fun showMotivasi(motivasiData : List<TumbuhanItem>)

    }
    interface Presenter{
        fun getMotivasi()
    }
}