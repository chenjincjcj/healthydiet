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
import com.example.ccccccc.PengrenActivity2
import com.example.ccccccc.PengrenAdapter
import com.example.ccccccc.R
import com.example.ccccccc.xiaxian.Pengren
import com.example.ccccccc.xiaxian.Yangsheng
import com.example.ccccccc.xiaxian.YangshengActivity2

class YangshengAdapter(val context: Context, val yangshengList: ArrayList<Yangsheng>) :
    RecyclerView.Adapter<YangshengAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val yangshengVideoView: ImageView = view.findViewById(R.id.yangsheng_voide)
        val yangshengName: TextView = view.findViewById(R.id.yangshengName)
        val yangshengmsage: TextView =view.findViewById(R.id.yangshengMsage)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YangshengAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.yangsheng_item, parent, false)
        val holder = ViewHolder(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val yangsheng = yangshengList[position]
            val intent = Intent(context, YangshengActivity2::class.java).apply {
                putExtra(YangshengActivity2.YANGSHENG_NAME, yangsheng.name)
                putExtra(YangshengActivity2.YANGSHENG_VOID_ID, yangsheng.voidid)
                putExtra(YangshengActivity2.YANGSHENG_MSAGE, yangsheng.masage)
            }
            context.startActivity(intent)
        }
        return holder}

    override fun getItemCount() = yangshengList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Yangsheng = yangshengList[position]
        holder.yangshengName.text = Yangsheng.name
        Glide.with(context).load(Yangsheng.voidid).into(holder.yangshengVideoView)
    }
}