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
import com.example.ccccccc.xiaxian.Shucai
import com.example.ccccccc.ShucaiActivity2


class ShucaiAdapter(val context: Context, val shucaiList: ArrayList<Shucai>) :
    RecyclerView.Adapter<ShucaiAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shucaiImage: ImageView = view.findViewById(R.id.shucaiImage)
        val shucaiName: TextView = view.findViewById(R.id.shucaiName)
        val shucaimsage:TextView=view.findViewById(R.id.shucaiMsage)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.shucai_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val shucai = shucaiList[position]
            val intent = Intent(context, ShucaiActivity2::class.java).apply {
                putExtra(ShucaiActivity2.SHUCAI_NAME, shucai.name)
                putExtra(ShucaiActivity2.SHUCAI_IMAGE_ID, shucai.imageId)
                putExtra(ShucaiActivity2.SHUCAI_MSAGE, shucai.msage)
            }
            context.startActivity(intent)
        }
        return holder}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shucai = shucaiList[position]
        holder.shucaiName.text = shucai.name
        Glide.with(context).load(shucai.imageId).into(holder.shucaiImage)

    }
    override fun getItemCount() = shucaiList.size
}