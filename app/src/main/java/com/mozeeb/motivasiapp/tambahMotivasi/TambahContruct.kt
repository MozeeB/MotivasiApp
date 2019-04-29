package com.mozeeb.motivasiapp.tambahMotivasi

interface TambahContruct {
    interface View{
        fun onSuccess()
        fun onFailed()
        fun formValidate()
    }
    interface Presenter{
        fun postMotivasi(judul : String, motivasi : String, penulis :String, tanggal : String)
    }
}