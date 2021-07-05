package com.mozeeb.motivasiapp.adapater

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mozeeb.motivasiapp.DetailMotivasiActivity
import com.mozeeb.motivasiapp.R
import com.mozeeb.motivasiapp.model.TumbuhanItem

class AdapterMotivasi : RecyclerView.Adapter<AdapterMotivasi.ViewHolder> {


    var motivasiData: List<TumbuhanItem>? = null
    var mContext: Context? = null

    constructor(c: Context?, data: List<TumbuhanItem>?) {
        this.mContext = c
        this.motivasiData = data
    }


    override fun getItemCount(): Int {
        return motivasiData!!.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var inflater = LayoutInflater.from(mContext).inflate(R.layout.item_motivasi, p0, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.judul?.text = motivasiData?.get(p1)?.judul
        p0.penulis?.text = motivasiData?.get(p1)?.penulis
        p0.tanggal?.text = motivasiData?.get(p1)?.tanggal

        p0.itemView.setOnClickListener {
            var intent = Intent(mContext, DetailMotivasiActivity::class.java)
            intent.putExtra("judul", motivasiData?.get(p1)?.judul)
            intent.putExtra("motivasi",motivasiData?.get(p1)?.motivasi)
            intent.putExtra("penulis", motivasiData?.get(p1)?.penulis)
            intent.putExtra("tanggal", motivasiData?.get(p1)?.tanggal)
            mContext?.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var judul = itemView?.findViewById<TextView>(R.id.tv_judul)
        var penulis = itemView?.findViewById<TextView>(R.id.tv_penulis)
        var tanggal = itemView?.findViewById<TextView>(R.id.tv_tanggal)

    }

}
