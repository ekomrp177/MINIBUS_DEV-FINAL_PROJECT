package com.kcb.android.tourismguide.ui.favorite.culinaryfav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecycleViewCulinaryAdapter
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.kcb.android.tourismguide.room.culinary.CulinaryDatabase
import com.kcb.android.tourismguide.ui.culinary.CulinaryDetailActivity
import kotlinx.android.synthetic.main.fragment_culinary_favorite.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CulinaryFavoriteFragment : Fragment() {
    private lateinit var favCulinaryAdapter: RecycleViewCulinaryAdapter
    private val listItems = ArrayList<CulinaryParcelable>()
    internal var culinaryDatabase: CulinaryDatabase? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_culinary_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        culinaryDatabase = CulinaryDatabase.getInstance(layoutInflater.context)
        GlobalScope.launch {
            context?.run {
                val culinary = culinaryDatabase?.culinaryDao()?.getAll()
                if(culinary!!.isNotEmpty()){
                    for (i in culinary.indices){
                        val getItems = CulinaryParcelable()
                        getItems.title = culinary[i].title
                        getItems.description = culinary[i].description
                        getItems.photo = culinary[i].photo
                        getItems.timeClose = culinary[i].timeClose
                        getItems.timeOpen = culinary[i].timeOpen
                        getItems.price = culinary[i].price
                        getItems.address = culinary[i].address
                        getItems.id = culinary[i].id
                        listItems.add(getItems)
                    }
                    tv_cekdata.text = ""
                    progressBar.visibility = View.INVISIBLE
                    favCulinaryAdapter.setData(listItems)
                }else{
                    progressBar.visibility = View.INVISIBLE
                    tv_cekdata.text = getString(R.string.favorite_information)
                }
            }
        }

        favCulinaryAdapter = RecycleViewCulinaryAdapter()
        favCulinaryAdapter.notifyDataSetChanged()
        recycleviewFavorite.layoutManager = LinearLayoutManager(context)
        recycleviewFavorite.adapter = favCulinaryAdapter

        favCulinaryAdapter.setOnItemClickCallBack(object : RecycleViewCulinaryAdapter.OnItemClickCallBack{
            override fun onItemClicked(culinaryParcelable: CulinaryParcelable) {
                val intent = Intent(context, CulinaryDetailActivity::class.java)
                intent.putExtra(CulinaryDetailActivity.EXTRA_DATA, culinaryParcelable)
                startActivity(intent)
            }
        })

    }
}