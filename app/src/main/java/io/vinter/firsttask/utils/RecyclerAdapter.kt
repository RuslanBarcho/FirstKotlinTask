package io.vinter.firsttask.utils

import android.content.Context
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import io.vinter.firsttask.R
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.MessageFormat
import java.util.*

class RecyclerAdapter(private var items : ArrayList<Int>, private val context: Context) :
        RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>() {

    override fun onBindViewHolder(holder: MainViewHolder, index: Int) {
        holder.text.text = items[index].getOrdinal()
        if (index % 2 == 0) holder.itemView.background = context.resources.getDrawable(R.color.colorWhite)
        else holder.itemView.background = context.resources.getDrawable(R.color.colorGrey)
        GlideApp.with(context)
                .load("https://www.usmagazine.com/wp-content/uploads/2018/06/Smoothie-the-Cat-Instagram-zoom.jpg")
                .override(300, 300)
                .transforms(CenterCrop(), RoundedCorners(30))
                .into(holder.pic)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pic = itemView.item_pic!!
        val text = itemView.item_text!!
    }

    private fun Number?.getOrdinal(): String {
        val format = "{0,spellout}"
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            android.icu.text.MessageFormat.format(format, this)
        } else {
            MessageFormat.format(format, this)
        }
    }
}