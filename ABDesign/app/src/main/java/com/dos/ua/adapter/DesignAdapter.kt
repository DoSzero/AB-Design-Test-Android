package com.dos.ua.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dos.ua.R
import com.dos.ua.databinding.ItemListBinding
import com.dos.ua.model.DesignData
import com.dos.ua.view.ItemMenuActivity

class DesignAdapter(var c:Context, var designList:ArrayList<DesignData>)
    :RecyclerView.Adapter<DesignAdapter.DesignViewHolder>() {

    inner class DesignViewHolder(var v: ItemListBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesignViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemListBinding>(inflater, R.layout.item_list,parent, false)

        return DesignViewHolder(v)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: DesignViewHolder, position: Int) {
        val newList = designList[position]

        holder.v.isDesign = designList[position]
        holder.v.root.setOnClickListener {

//            val imgMain = newList.imgMain
//            val nameMain = newList.nameMain
//            val infoMain = newList.infoMain

            val imgA = newList.imgA
            val nameA = newList.nameA
            val infoA = newList.infoA

            val imgB = newList.imgB
            val nameB = newList.nameB
            val infoB = newList.infoB

            // set Data
            val mIntent = Intent(c, ItemMenuActivity::class.java)

//            mIntent.putExtra("imgLogo",imgMain)
//            mIntent.putExtra("nameLogo",nameMain)
//            mIntent.putExtra("infoLogo",infoMain)

            mIntent.putExtra("imgA",imgA)
            mIntent.putExtra("nameA",nameA)
            mIntent.putExtra("infoA",infoA)

            mIntent.putExtra("imgB",imgB)
            mIntent.putExtra("nameB",nameB)
            mIntent.putExtra("infoB",infoB)

            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
       return  designList.size
    }
}