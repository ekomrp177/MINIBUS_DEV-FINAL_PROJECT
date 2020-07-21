package com.kcb.android.tourismguide.ui.tour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.RecyclerViewTourAdapter
import com.kcb.android.tourismguide.parcelable.TourParcelable
import com.kcb.android.tourismguide.viewmodel.tour.TourViewModel
import kotlinx.android.synthetic.main.fragment_tour.*

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

        tourViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TourViewModel::class.java)

        tourViewModel.setTourAttraction()
        tourViewModel.getTourAttraction().observe(viewLifecycleOwner, Observer { TourParcelable ->
            if(TourParcelable != null) {
                adapter.setData(TourParcelable)
                progressBar.visibility = View.INVISIBLE
            }
        })
        
    }
}