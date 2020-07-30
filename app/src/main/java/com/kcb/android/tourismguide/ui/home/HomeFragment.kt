package com.kcb.android.tourismguide.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.kcb.android.tourismguide.MainActivity.Companion.job
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecycleViewCulinaryAdapter
import com.kcb.android.tourismguide.adapter.RecyclerViewTourAdapter
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.kcb.android.tourismguide.room.culinary.CulinaryDatabase
import com.kcb.android.tourismguide.room.tour.TourDatabase
import com.kcb.android.tourismguide.ui.culinary.CulinaryDetailActivity
import com.kcb.android.tourismguide.ui.tour.TourDetailActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var adapter: RecyclerViewTourAdapter
    private lateinit var adapterCul: RecycleViewCulinaryAdapter
    private val listItems = ArrayList<TourParcelable>()
    private val listItemsCul = ArrayList<CulinaryParcelable>()
    private var tourDatabase: TourDatabase? = null
    private var culinaryDatabase: CulinaryDatabase? = null

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
        job?.cancel()
        culinaryDatabase = CulinaryDatabase.getInstance(layoutInflater.context)
        tourDatabase = TourDatabase.getInstance(layoutInflater.context)
        job = GlobalScope.launch {
            context?.run {
                val tour = tourDatabase?.tourDao()?.getAll()
                if(tour!!.isNotEmpty()){
                    val random = (tour.indices).random()
                    listItems.add(tour[random])
                    adapter.setData(listItems)
                    tv_norecom.text = ""
                }else{
                    tv_norecom.text = "No Favorites Place, its mean no recommendation, please add some favorite"
                }
            }
            context?.run {
                val culinary = culinaryDatabase?.culinaryDao()?.getAll()
                if (culinary!!.isNotEmpty()){
                    val random = (culinary.indices).random()
                    listItemsCul.add(culinary[random])
                    adapterCul.setData(listItemsCul)
                    tv_norecom1.text = ""
                }else{
                    tv_norecom1.text = "No Favorites Place, its mean no recommendation, please add some favorite"
                }
            }
        }

        adapter = RecyclerViewTourAdapter()
        adapter.notifyDataSetChanged()
        recycleview_tour.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycleview_tour.adapter = adapter

        adapterCul = RecycleViewCulinaryAdapter()
        adapterCul.notifyDataSetChanged()
        recycleview_culinary.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycleview_culinary.adapter = adapterCul

        adapter.setOnItemClickCallBack(object : RecyclerViewTourAdapter.OnItemClickCallBack {
            override fun onItemClicked(tourParcelable: TourParcelable) {
                val intent = Intent(context, TourDetailActivity::class.java)
                intent.putExtra(TourDetailActivity.EXTRA_DATA, tourParcelable)
                startActivity(intent)
            }
        })
        adapterCul.setOnItemClickCallBack(object : RecycleViewCulinaryAdapter.OnItemClickCallBack {
            override fun onItemClicked(culinaryParcelable: CulinaryParcelable) {
                val intent = Intent(context, CulinaryDetailActivity::class.java)
                intent.putExtra(CulinaryDetailActivity.EXTRA_DATA, culinaryParcelable)
                startActivity(intent)
            }
        })
        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/heha-sky-view.jpg", "Travel makes one modest. You see what a tiny place you occupy in the world."))
        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/rekomendasi-wisata-jogja-hits-buat-kamu-yang-liburan-di-yogyakarta.jpg", "“Live your life by a compass, not a clock"))
        imageList.add(SlideModel("https://cdn2.tstatic.net/jogja/foto/bank/images/dekorasi-musim-salju-hiasi-perkemahan-glamping-kaliurang.jpg", "A journey is best measured in friends, rather than miles."))
        image_slider.setImageList(imageList)
    }
}