package com.mozeeb.motivasiapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_motivasi.*

class DetailMotivasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_motivasi)

        tv_judul_detail.text = intent.getStringExtra("judul")
        tv_penulis_detail.text = intent.getStringExtra("penulis")
        tv_tanggal_detail.text = intent.getStringExtra("tanggal")
        tv_motivasi_detail.text = intent.getStringExtra("motivasi")
    }
}
