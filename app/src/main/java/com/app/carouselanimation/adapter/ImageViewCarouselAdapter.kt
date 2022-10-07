package com.app.carouselanimation.adapter

import android.content.Context
import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.carouselanimation.R
import com.bumptech.glide.Glide

class ImageViewCarouselAdapter(var imageList: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<ImageViewCarouselAdapter.ImageViewCarouselViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewCarouselViewHolder {
        return ImageViewCarouselAdapter.ImageViewCarouselViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewCarouselViewHolder, position: Int) {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        var newWidth = 0
        newWidth = (width * 0.90).toInt()
        val layoutParams =
            RelativeLayout.LayoutParams(newWidth, RelativeLayout.LayoutParams.WRAP_CONTENT)
        if (imageList.size > 1) {
            layoutParams.marginStart = 8
            layoutParams.marginEnd = 8
        } else {
            layoutParams.marginStart = ((width - newWidth) / 2)
        }
        holder.image?.layoutParams = layoutParams
        Glide.with(context)
            .load(imageList[position])
            .placeholder(R.drawable.empty_placeholder)
            .into(holder.image!!)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    class ImageViewCarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView? = null

        init {
            image = itemView.findViewById(R.id.image)
        }
    }
}