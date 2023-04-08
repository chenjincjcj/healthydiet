package com.example.ccccccc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ccccccc.xiaxian.Pengren

class PengrenAdapter(val context: Context, val pengrenList: ArrayList<Pengren>) :
    RecyclerView.Adapter<PengrenAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pengrenVideoView:ImageView= view.findViewById(R.id.pengren_voide)
        val pengrenName: TextView = view.findViewById(R.id.pengrenName)
        val pengrenmsage: TextView =view.findViewById(R.id.pengrenMsage)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pengren_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val pengren = pengrenList[position]
            val intent = Intent(context, PengrenActivity2::class.java).apply {
                putExtra(PengrenActivity2.PENGREN_NAME, pengren.name)
                putExtra(PengrenActivity2.PENGREN_VOID_ID, pengren.voidid)
                putExtra(PengrenActivity2.PENGREN_MSAGE, pengren.masage)
            }
            context.startActivity(intent)
        }
        return holder}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pengren = pengrenList[position]
        holder.pengrenName.text = pengren.name
        Glide.with(context).load(pengren.voidid).into(holder.pengrenVideoView)



    }
    override fun getItemCount() = pengrenList.size
}



