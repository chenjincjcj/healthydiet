package com.example.ccccccc.Adaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ccccccc.R
import com.example.ccccccc.Zhushi
import com.example.ccccccc.ZhushiActivity2


class ZhushiAdapter(val context1: Context, val zhushiList: ArrayList<Zhushi>) :
    RecyclerView.Adapter<ZhushiAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val zhushiImage: ImageView = view.findViewById(R.id.zhushiImage)
        val zhushiName: TextView = view.findViewById(R.id.zhushiName)
        val zhushimsage:TextView=view.findViewById(R.id.zhushiMsage)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context1).inflate(R.layout.zhushi_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val zhushi = zhushiList[position]
            val intent2 = Intent(context1, ZhushiActivity2::class.java).apply {
                putExtra(ZhushiActivity2.FRUIT_NAME, zhushi.name)
                putExtra(ZhushiActivity2.FRUIT_IMAGE_ID, zhushi.imageId)
                putExtra(ZhushiActivity2.FRUIT_MSAGE, zhushi.msage)
            }
            context1.startActivity(intent2)
        }
        return holder}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zhushi = zhushiList[position]
        holder.zhushiName.text = zhushi.name
        Glide.with(context1).load(zhushi.imageId).into(holder.zhushiImage)

    }
    override fun getItemCount() = zhushiList.size
}