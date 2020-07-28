package com.kcb.android.tourismguide.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.kcb.android.tourismguide.R
import com.kcb.android.tourismguide.adapter.FavoritePagerAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val favoritePagerAdapter = FavoritePagerAdapter(layoutInflater.context, childFragmentManager)
        view_pager.adapter = favoritePagerAdapter
        tabs.setupWithViewPager(view_pager)
        (activity as AppCompatActivity).supportActionBar?.elevation = 0f
    }

}