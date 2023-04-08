package com.example.ccccccc.ui.kepu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ccccccc.PengrenActivity2
import com.example.ccccccc.R

class KepuAdapter(val context: Context, val pengrenList: ArrayList<Kepu>) :
    RecyclerView.Adapter<KepuAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kepuVideoView: ImageView = view.findViewById(R.id.pengren_voide)
        val kepuName: TextView = view.findViewById(R.id.pengrenName)
        val kepumsage: TextView =view.findViewById(R.id.pengrenMsage)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pengren_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val kepu = pengrenList[position]
            val intent = Intent(context, KepuActivity2::class.java).apply {
                putExtra(KepuActivity2.KEPU_NAME, kepu.name)
                putExtra(KepuActivity2.KEPU_VOID_ID, kepu.voidid)
                putExtra(KepuActivity2.KEPU_MSAGE, kepu.masage)
            }
            context.startActivity(intent)
        }
        return holder}

    override fun getItemCount() = pengrenList.size
    override fun onBindViewHolder(holder: KepuAdapter.ViewHolder, position: Int) {
        val kepu = pengrenList[position]
        holder.kepuName.text = kepu.name
        Glide.with(context).load(kepu.voidid).into(holder.kepuVideoView)

    }
}

