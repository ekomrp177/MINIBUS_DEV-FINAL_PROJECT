package com.kcb.android.tourismguide.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ViewFlipper
import com.denzcoskun.imageslider.models.SlideModel
import com.kcb.android.tourismguide.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val imageList = ArrayList<SlideModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/heha-sky-view.jpg", "Travel makes one modest. You see what a tiny place you occupy in the world."))
        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/rekomendasi-wisata-jogja-hits-buat-kamu-yang-liburan-di-yogyakarta.jpg", "“Live your life by a compass, not a clock"))
        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/dekorasi-musim-salju-hiasi-perkemahan-glamping-kaliurang.jpg", "A journey is best measured in friends, rather than miles."))

        image_slider.setImageList(imageList)
    }
}