package com.example.ccccccc.ui.shequ

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ccccccc.R

class ShequAdaper(val shequList: MutableList<Shequ>) :
RecyclerView.Adapter<ShequAdaper.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shequImage: ImageView = view.findViewById(R.id.shequ_image)
        val shequName: TextView = view.findViewById(R.id.shequ_name)
        val shequMsage: TextView = view.findViewById(R.id.shequ_msage)

    }
    fun addCourse(shequ: Shequ) {
shequList.add(0,shequ)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ShequAdaper.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shequ_iten, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shequ = shequList[position]
        holder.shequImage.setImageBitmap(shequ.Bitemp)
        holder.shequName.text = shequ.name
        holder.shequMsage.text=shequ.masage

    }



    override fun getItemCount() = shequList.size
}

