package com.mozeeb.motivasiapp.getMotivasi

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.mozeeb.motivasiapp.R
import com.mozeeb.motivasiapp.adapater.AdapterMotivasi
import com.mozeeb.motivasiapp.model.TumbuhanItem
import com.mozeeb.motivasiapp.tambahMotivasi.TambahMotivasi
import es.dmoral.toasty.Toasty

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , getMotivasiContruct.View {

    lateinit var presenter: getMotivasiPresenter

    lateinit var rv_main : RecyclerView
    lateinit var adapter : AdapterMotivasi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        presenter = getMotivasiPresenter(this)

        fab.setOnClickListener { view ->
            startActivity(Intent(this, TambahMotivasi::class.java))
        }
        rv_main = this.findViewById(R.id.rv_main)
        rv_main.setHasFixedSize(true)
        presenter.getMotivasi()
    }

    override fun showMotivasi(motivasiData: List<TumbuhanItem>) {
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = AdapterMotivasi(this, motivasiData)
    }



    override fun onSuccess() {
        Toasty.success(this, "Welcome!", Toasty.LENGTH_LONG).show()

    }

    override fun onFailed() {
        Toasty.error(this, "Failed!", Toasty.LENGTH_LONG).show()

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
