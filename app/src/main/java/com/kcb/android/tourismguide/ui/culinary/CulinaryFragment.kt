package com.kcb.android.tourismguide.ui.culinary

import android.content.Intent
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecycleViewCulinaryAdapter
import com.kcb.android.tourismguide.adapter.RecyclerViewTourAdapter
import com.kcb.android.tourismguide.parcelable.CulinaryParcelable
import com.kcb.android.tourismguide.viewmodel.culinary.CulinaryViewModel
import com.kcb.android.tourismguide.viewmodel.tour.TourViewModel
import kotlinx.android.synthetic.main.fragment_tour.*

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

        culinaryViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(CulinaryViewModel::class.java)

        culinaryViewModel.setCulinary()
        culinaryViewModel.getCulinary().observe(viewLifecycleOwner, Observer { Culinary ->
            if(Culinary != null) {
                adapter.setData(Culinary)
                progressBar.visibility = View.INVISIBLE
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
}