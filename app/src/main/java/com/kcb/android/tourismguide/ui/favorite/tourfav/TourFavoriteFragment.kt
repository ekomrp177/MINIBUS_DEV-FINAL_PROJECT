package com.kcb.android.tourismguide.ui.favorite.tourfav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecyclerViewTourAdapter
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.kcb.android.tourismguide.room.tour.TourDatabase
import com.kcb.android.tourismguide.ui.tour.TourDetailActivity
import kotlinx.android.synthetic.main.fragment_tour_favorite.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TourFavoriteFragment : Fragment() {
    private lateinit var favTourFavoriteAdapter: RecyclerViewTourAdapter
    private val listItems = ArrayList<TourParcelable>()
    private var tourDatabase: TourDatabase? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tour_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tourDatabase = TourDatabase.getInstance(layoutInflater.context)
        GlobalScope.launch {
            context?.run {
                val tour = tourDatabase?.tourDao()?.getAll()
                if(tour!!.isNotEmpty()){
                    for (i in tour.indices){
                        val getItems = TourParcelable()
                        getItems.title = tour[i].title
                        getItems.description = tour[i].description
                        getItems.photo = tour[i].photo
                        getItems.timeClose = tour[i].timeClose
                        getItems.timeOpen = tour[i].timeOpen
                        getItems.price = tour[i].price
                        getItems.address = tour[i].address
                        getItems.id = tour[i].id
                        listItems.add(getItems)
                    }
                    tv_cekdata.text = ""
                    progressBar.visibility = View.INVISIBLE
                    favTourFavoriteAdapter.setData(listItems)
                }else{
                    progressBar.visibility = View.INVISIBLE
                    tv_cekdata.text = getString(R.string.favorite_information)
                }
            }
        }

        favTourFavoriteAdapter = RecyclerViewTourAdapter()
        favTourFavoriteAdapter.notifyDataSetChanged()
        recycleviewFavorite.layoutManager = LinearLayoutManager(context)
        recycleviewFavorite.adapter = favTourFavoriteAdapter

        favTourFavoriteAdapter.setOnItemClickCallBack(object : RecyclerViewTourAdapter.OnItemClickCallBack{
            override fun onItemClicked(tourParcelable: TourParcelable) {
                val intent = Intent(context, TourDetailActivity::class.java)
                intent.putExtra(TourDetailActivity.EXTRA_DATA, tourParcelable)
                startActivity(intent)
            }
        })
    }
}