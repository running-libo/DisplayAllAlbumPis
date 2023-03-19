package com.example.displayanbum

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import java.io.File

class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var datas = ArrayList<PicBean>()

    fun setDatas(datas: ArrayList<PicBean>) {
        this.datas = datas
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var ivCover: ImageView?= null
        var tvTitle: TextView?= null
        init {
            ivCover = itemView.findViewById(R.id.iv_cover)
            tvTitle = itemView.findViewById(R.id.tv_title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        datas[position]?.let {
            holder.tvTitle?.text = it.name
            holder.ivCover?.load(File(it.path))
        }
    }

    override fun getItemCount(): Int = datas.size
}