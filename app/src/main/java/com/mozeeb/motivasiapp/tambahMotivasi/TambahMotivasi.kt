package com.mozeeb.motivasiapp.tambahMotivasi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mozeeb.motivasiapp.R
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_tambah_motivasi.*

class TambahMotivasi : AppCompatActivity() , TambahContruct.View{

    lateinit var presenter: TambahPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_motivasi)

        presenter = TambahPresenter(this)

        btn_motivasi.setOnClickListener {
            presenter.postMotivasi(edt_judul.text.toString(),
                edt_motivasi.text.toString(), edt_penulis.text.toString(),
                edt_tanggal.text.toString())
        }


    }

    override fun onSuccess() {
        Toasty.success(this, "Tambah Motivasi Successfully!", Toasty.LENGTH_LONG).show()

    }

    override fun onFailed() {
        Toasty.error(this, "Tambah Motivasi Failed!", Toasty.LENGTH_LONG).show()

    }

    override fun formValidate() {
        Toasty.error(this, "Form must be valid!", Toasty.LENGTH_LONG).show()
    }
}
