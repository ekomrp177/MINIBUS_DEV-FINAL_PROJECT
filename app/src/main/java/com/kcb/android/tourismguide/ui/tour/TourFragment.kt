package com.kcb.android.tourismguide.ui.tour

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kcb.android.tourismguide.MainActivity.Companion.job
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecyclerViewTourAdapter
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.kcb.android.tourismguide.viewmodel.tour.TourViewModel
import kotlinx.android.synthetic.main.fragment_culinary.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TourFragment : Fragment() {
    private lateinit var adapter: RecyclerViewTourAdapter
    private lateinit var tourViewModel: TourViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tour, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = RecyclerViewTourAdapter()
        adapter.notifyDataSetChanged()

        recycleview.layoutManager = LinearLayoutManager(context)
        recycleview.adapter = adapter

        job?.cancel()
        job = GlobalScope.launch(context = Dispatchers.Main) {
            delay(5000)
            if (!verifyAvailableNetwork((activity as AppCompatActivity)) && adapter.itemCount == 0){
                progressBar.visibility = View.INVISIBLE
                internetconn.text = "Check your internet connection!"
            }
        }

        tourViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TourViewModel::class.java)

        tourViewModel.setTourAttraction()
        tourViewModel.getTourAttraction().observe(viewLifecycleOwner, Observer { TourParcelable ->
            if(TourParcelable != null) {
                progressBar.visibility = View.INVISIBLE
                adapter.setData(TourParcelable)
            }
        })
        adapter.setOnItemClickCallBack(object : RecyclerViewTourAdapter.OnItemClickCallBack {
            override fun onItemClicked(tourParcelable: TourParcelable) {
                var intent = Intent(context, TourDetailActivity::class.java)
                intent.putExtra(TourDetailActivity.EXTRA_DATA, tourParcelable)
                startActivity(intent)
            }
        })

    }
    private fun verifyAvailableNetwork(activity: AppCompatActivity):Boolean{
        val connectivityManager= activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo= connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}