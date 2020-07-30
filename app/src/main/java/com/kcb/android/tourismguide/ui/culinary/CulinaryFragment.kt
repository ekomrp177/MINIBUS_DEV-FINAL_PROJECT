package com.kcb.android.tourismguide.ui.culinary

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
import com.kcb.android.tourismguide.adapter.RecycleViewCulinaryAdapter
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.kcb.android.tourismguide.viewmodel.culinary.CulinaryViewModel
import kotlinx.android.synthetic.main.fragment_culinary.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CulinaryFragment : Fragment() {
    private lateinit var adapter: RecycleViewCulinaryAdapter
    private lateinit var culinaryViewModel: CulinaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_culinary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = RecycleViewCulinaryAdapter()
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

        culinaryViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(CulinaryViewModel::class.java)

        culinaryViewModel.setCulinary()
        culinaryViewModel.getCulinary().observe(viewLifecycleOwner, Observer { Culinary ->
            if(Culinary != null) {
                progressBar?.visibility = View.INVISIBLE
                adapter.setData(Culinary)
            }
        })
        adapter.setOnItemClickCallBack(object: RecycleViewCulinaryAdapter.OnItemClickCallBack{
            override fun onItemClicked(culinaryParcelable: CulinaryParcelable) {
                var intent = Intent(context,CulinaryDetailActivity::class.java)
                intent.putExtra(CulinaryDetailActivity.EXTRA_DATA, culinaryParcelable)
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