package com.app.carouselanimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.app.carouselanimation.adapter.ImageViewCarouselAdapter
import com.app.carouselanimation.utils.CarouselLayoutManager


class MainActivity : AppCompatActivity() {


    var recyclerView: RecyclerView? = null
    var layoutManager: CarouselLayoutManager? = null
    var snapHelper: SnapHelper? = null
    var imageList: ArrayList<String>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)

        //for carousel animation in recyclerview
        layoutManager =
            CarouselLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView?.layoutManager = layoutManager

        imageList?.add("https://picsum.photos/seed/picsum/200/300")
        imageList?.add("https://picsum.photos/id/0/5616/3744")
        imageList?.add("https://picsum.photos/id/10/2500/1667")
        imageList?.add("https://picsum.photos/id/1000/5626/3635")
        imageList?.add("https://picsum.photos/id/1003/1181/1772")
        imageList?.add("https://picsum.photos/id/101/2621/1747")


        //for recyclerview to behave like viewpager
        snapHelper = PagerSnapHelper()
        snapHelper?.attachToRecyclerView(recyclerView)

        val imageViewCarouselAdapter = ImageViewCarouselAdapter(imageList!!, this@MainActivity)
        recyclerView?.adapter = imageViewCarouselAdapter
    }
}